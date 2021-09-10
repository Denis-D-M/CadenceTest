package com.test.workflow;

import com.test.cadence.workflow.PropertyContractWorkflow;

public class RealPropertyCreatorImpl implements PropertyContractWorkflow {

  @Override
  public String getHello() {
    return "Я РЕАЛЬНО СДЕЛАЛ КОНТРАКТ!";
  }
}
