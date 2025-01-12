/*
 * SPDX-FileCopyrightText: 2017-2024 Enedis
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.chutneytesting.samples.sync

import com.chutneytesting.kotlin.synchronize.synchronise
import com.chutneytesting.kotlin.util.ChutneyServerInfo
import com.chutneytesting.samples.spec.eiffelTowerFlood

fun main() {
    DemoServer.synchronize()
}

object DemoServer {
    val CHUTNEY_DEMO = ChutneyServerInfo(
        url = "https://localhost:8443",
        user = "admin",
        password = "admin"
    )

    fun synchronize() {
        eiffelTowerFlood.synchronise(CHUTNEY_DEMO)
    }
}
