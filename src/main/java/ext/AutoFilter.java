/*
 * Copyright (c) 2019 Markus KARG. All rights reserved.
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

package ext;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Extension;

/**
 * A sample filter getting loaded automatically.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public class AutoFilter implements ContainerRequestFilter, ContainerResponseFilter, Extension {

	@Override
	public void filter(ContainerRequestContext requestContext) {
		System.out.println("----- >>>>> ----- " + this.hashCode());
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
		System.out.println("----- <<<<< ----- " + this.hashCode());
	}

}
