package com.test.configuration;

import com.test.workflow.RealPropertyCreatorImpl;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerRegister implements CommandLineRunner {

  @Override
  public void run(String... args) {
    WorkerFactory factory = WorkerFactory.newInstance(WorkflowClient.newInstance(
        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
        WorkflowClientOptions.newBuilder().setDomain("test-domain").build()));
    Worker worker = factory.newWorker("createProperty");
    worker.registerWorkflowImplementationTypes(RealPropertyCreatorImpl.class);
    factory.start();
  }
}
