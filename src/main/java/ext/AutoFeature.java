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

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Extension;

/**
 * A sample feature getting loaded automatically.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public class AutoFeature implements Feature, Extension {

	@Override
	public boolean configure(FeatureContext context) {
		System.out.println("AutoFeature loaded");
		return true;
	}

}
