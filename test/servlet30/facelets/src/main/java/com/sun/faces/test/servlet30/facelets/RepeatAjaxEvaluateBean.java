/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.servlet30.facelets;

import static java.util.Arrays.asList;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class RepeatAjaxEvaluateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final static List<String> list = asList("1", "2", "3");

    public List<String> getList1() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluated 1"));
        }
        return list;
    }

    public List<String> getList2() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluated 2"));
        }
        return list;
    }

    public List<String> getList3() {
        if (FacesContext.getCurrentInstance().isPostback()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evaluated 3"));
        }
        return list;
    }

    public String getCurrentDate() {
        return (new Date()).toString();
    }
}
