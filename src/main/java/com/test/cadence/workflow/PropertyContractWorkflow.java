package com.test.cadence.workflow;

import com.uber.cadence.workflow.WorkflowMethod;

public interface PropertyContractWorkflow {

  @WorkflowMethod(executionStartToCloseTimeoutSeconds = 100, taskList = "createProperty")
  String getHello();

}
