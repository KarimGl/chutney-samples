package com.chutneytesting.samples.spec

import com.chutneytesting.kotlin.dsl.ContextPutAction
import com.chutneytesting.kotlin.dsl.HttpGetAction
import com.chutneytesting.kotlin.dsl.JsonAssertAction
import com.chutneytesting.kotlin.dsl.Scenario
import com.chutneytesting.kotlin.dsl.spEL

val eiffelTowerFlood = Scenario(title = "Check if the Eiffel Tower is in a flood zone") {
    Given("I define the map coordinates of the Eiffel Tower") {
        ContextPutAction(
            entries = mapOf(
                "coordinates" to "2.294740248187982,48.858474895005195"
            )
        )
    }
    When("I ask the Geo Risk API to check the defined position") {
        HttpGetAction(
            target = "GEO-RISK",
            uri = "/tri_zonage?latlon=${"coordinates".spEL()}",
            headers = mapOf(
                "Accept" to "application/json",
                "User-Agent" to "Chutney client"),
            validations = mapOf(
                "status_ok" to "status == 200".spEL()
            )
        )
    }
    And("I verify that the Eiffel Tower is indeed in a flood zone") {
        JsonAssertAction(
            document = "body".spEL(),
            expected = mapOf(
                "$.results" to "\$isGreaterThan:0",
                "$.data[0].typeInondation.code" to "\$isNotNull"
            )
        )
    }
}
