package com.balionis.kotlin5

import mu.KotlinLogging
import org.activiti.engine.ProcessEngine
import org.activiti.engine.ProcessEngineConfiguration
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration
import org.activiti.engine.repository.Deployment

private val logger = KotlinLogging.logger {}

class App {

    private lateinit var processEngine: ProcessEngine

    fun init(args: List<String>) {
        logger.debug { "init: args=${args.joinToString()}" }

        val cfg = StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
        processEngine = cfg.buildProcessEngine()
        logger.debug { "init: pName=${processEngine.name}, version=${ProcessEngine.VERSION}" }
    }

    fun deploy(flow: String) {
        val repositoryService = processEngine.repositoryService
        val deployment: Deployment = repositoryService.createDeployment()
                .addClasspathResource(flow).deploy()
        val processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult()
        logger.debug { "deploy: name=${processDefinition.name}, id=${processDefinition.id}" }
    }
}

fun main(args: Array<String>) {

    val app = App()

    app.init(args.asList())

    app.deploy("sample2.bpmn20.xml")

    logger.debug { "main: done" }

}
