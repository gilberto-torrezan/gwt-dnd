/*
 * Copyright 2006 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.dragdrop.client.drop;

import com.google.gwt.user.client.ui.Panel;

import com.allen_sauer.gwt.dragdrop.client.DragAndDropController;
import com.allen_sauer.gwt.dragdrop.client.DropControllerCollection;

/**
 * Base class for all drop controllers with basic functionality.
 */
public abstract class AbstractDropController implements DropController {

  private Panel dropTargetPanel;

  public AbstractDropController(Panel dropTargetPanel) {
    this.dropTargetPanel = dropTargetPanel;
    DropControllerCollection.singleton().add(this);
    dropTargetPanel.addStyleName(getDropTargetStyleName());
  }

  public void drop(DragAndDropController dragAndDropController) {
    this.dropTargetPanel.removeStyleName("pre-drop");
  }

  public Panel getDropTargetPanel() {
    return this.dropTargetPanel;
  }

  public abstract String getDropTargetStyleName();

  public boolean onDrop(DragAndDropController dragAndDropController) {
    this.dropTargetPanel.removeStyleName("pre-drop");
    return true;
  }

  public void onEnter(DragAndDropController dragAndDropController) {
    this.dropTargetPanel.addStyleName("pre-drop");
  }

  public void onLeave(DragAndDropController dragAndDropController) {
    this.dropTargetPanel.removeStyleName("pre-drop");
  }

  public void onMove(DragAndDropController dragAndDropController) {
  }

}
