/*
 * Copyright (C) 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.pippo.demo.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ro.pippo.controller.ControllerApplication;
import ro.pippo.core.route.PublicResourceHandler;
import ro.pippo.core.route.WebjarsResourceHandler;
import ro.pippo.guice.GuiceControllerFactory;

/**
 * @author James Moger
 */
public class GuiceApplication extends ControllerApplication {

    @Override
    protected void onInit() {
        // create guice injector
        Injector injector = Guice.createInjector(new GuiceModule());

        // registering GuiceControllerFactory
        setControllerFactory(new GuiceControllerFactory(injector));

        GET(new WebjarsResourceHandler());
        GET(new PublicResourceHandler());

        // add controller
        GET("/", ContactsController.class, "index");
    }

}
