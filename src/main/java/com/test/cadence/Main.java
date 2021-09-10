package com.test.cadence;

import com.test.cadence.workflow.PropertyContractWorkflow;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.WorkerFactory;

public class Main {

  private static final String DOMAIN = "test-domain";

  public static void main(String[] args) {
    WorkflowClient workflowClient =
        WorkflowClient.newInstance(
            new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
            WorkflowClientOptions.newBuilder().setDomain(DOMAIN).build());
    // Get worker to poll the task list.
    WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
    PropertyContractWorkflow helloWorldWorkflow = workflowClient.newWorkflowStub(PropertyContractWorkflow.class);
    factory.start();
    System.out.println(helloWorldWorkflow.getHello());

  }

}
