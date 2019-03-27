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

import java.net.URI;

import javax.ws.rs.JAXRS;
import javax.ws.rs.JAXRS.Configuration;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

public class HelloWorld {
	public static void main(String[] args) throws InterruptedException {
		Application application = new HelloWorldApplication();

		Configuration configuration = Configuration.builder().protocol("http").host("localhost").port(8080).build();

		JAXRS.start(application, configuration).thenAccept(instance -> {
			Runtime.getRuntime()
					.addShutdownHook(new Thread(() -> instance.stop()
							.thenAccept(stopResult -> System.out.printf("Stop result: %s [Native stop result: %s]%n",
									stopResult, stopResult.unwrap(Object.class)))));

			final Configuration actualConfigurarion = instance.configuration();
			final URI uri = UriBuilder.newInstance().scheme(actualConfigurarion.protocol().toLowerCase())
					.host(actualConfigurarion.host()).port(actualConfigurarion.port())
					.path(actualConfigurarion.rootPath()).build();

			System.out.printf("Listening to %s - Send SIGKILL to shutdown.%n", uri);
		});

		Thread.currentThread().join();
	}
}
