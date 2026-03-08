package com.six2dez.burp.aiagent.backends.cli

import com.six2dez.burp.aiagent.backends.AiBackend
import com.six2dez.burp.aiagent.backends.AiBackendFactory

class IFlowCliBackendFactory : AiBackendFactory {
    override fun create(): AiBackend = CliBackend(
        id = "iflow-cli",
        displayName = "iFlow CLI"
    )
}
