package com.chutneytesting.sample.spec

import com.chutneytesting.kotlin.dsl.Environment
import com.chutneytesting.kotlin.launcher.Launcher
import com.chutneytesting.samples.spec.eiffelTowerFlood
import org.junit.jupiter.api.Test

class `EiffelTowerFloodTest.kt` {

    val GOVERNMENT_DATA = Environment(name = "French public data api ", description = "powered by https://www.data.gouv.fr/") {
        Target {
            Name("GEO-RISK")
            Url("https://georisques.gouv.fr/api/v1")
        }
    }

    @Test
    fun `Eiffel Tower should be in a flood zone` () {
        Launcher().run(eiffelTowerFlood, GOVERNMENT_DATA)
    }
}
