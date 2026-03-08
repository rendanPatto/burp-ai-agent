# 用户指令记忆

本文件记录了用户的指令、偏好和教导，用于在未来的交互中提供参考。

## 格式

### 用户指令条目
用户指令条目应遵循以下格式：

[用户指令摘要]
- Date: [YYYY-MM-DD]
- Context: [提及的场景或时间]
- Instructions:
  - [用户教导或指示的内容，逐行描述]

### 项目知识条目
Agent 在任务执行过程中发现的条目应遵循以下格式：

[项目知识摘要]
- Date: [YYYY-MM-DD]
- Context: Agent 在执行 [具体任务描述] 时发现
- Category: [代码结构|代码模式|代码生成|构建方法|测试方法|依赖关系|环境配置]
- Instructions:
  - [具体的知识点，逐行描述]

## 去重策略
- 添加新条目前，检查是否存在相似或相同的指令
- 若发现重复，跳过新条目或与已有条目合并
- 合并时，更新上下文或日期信息
- 这有助于避免冗余条目，保持记忆文件整洁

## 条目

[项目结构概览]
- Date: 2026-03-08
- Context: Agent 在执行项目了解任务时发现
- Category: 代码结构
- Instructions:
  - Burp AI Agent 是一个 Burp Suite 扩展，用于集成 AI 到安全测试工作流
  - 项目使用 Kotlin + Gradle 构建，目标 Java 21
  - 入口类: BurpAiAgentExtension，核心应用对象: App
  - 主要模块: backends (AI 后端)、mcp (MCP 服务器)、scanner (扫描器)、ui (界面)、supervisor (AI 调度)
  - 支持 7 种 AI 后端: Ollama, LM Studio, OpenAI-compatible, Gemini CLI, Claude CLI, Codex CLI, OpenCode CLI
  - 构建命令: ./gradlew clean shadowJar，输出: build/libs/Burp-AI-Agent-<version>.jar
  - 测试框架: JUnit 5 + mockito-kotlin

[后端架构模式]
- Date: 2026-03-08
- Context: Agent 在分析 backends 模块时发现
- Category: 代码模式
- Instructions:
  - 每个后端类型有独立的 Factory 类负责创建 Backend 实例
  - 后端分为 HTTP 类型 (Ollama, LM Studio, OpenAI-compatible) 和 CLI 类型 (Claude, Codex, Gemini, OpenCode)
  - BackendRegistry 负责管理所有后端实例

[MCP 工具注册模式]
- Date: 2026-03-08
- Context: Agent 在分析 mcp/tools 模块时发现
- Category: 代码模式
- Instructions:
  - MCP 工具定义在 mcp/tools/ 目录下，按功能分类 (SiteMap, Request, Scanner, Issue 等)
  - McpToolCatalog 负责工具目录管理
  - 工具通过 McpToolHandlers 统一分发处理
