/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinax.kubernetes.handlers;

import org.ballerinax.kubernetes.models.DeploymentModel;
import org.ballerinax.kubernetes.models.KubernetesDataHolder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.io.File;

@RunWith(Suite.class)
@SuiteClasses({DockerGeneratorTests.class, KubernetesSecretGeneratorTests.class, KubernetesConfigMapGeneratorTests
        .class, KubernetesDeploymentGeneratorTests.class, KubernetesHPAGeneratorTests.class,
        KubernetesServiceGeneratorTests.class, KubernetesIngressGeneratorTests.class, KubernetesSecretGeneratorTests
        .class, KubernetesVolumeClaimGeneratorTests.class, KubernetesJobGeneratorTests.class})

public class HandlerTestSuite {

    @BeforeClass
    public static void setUp() {
        KubernetesDataHolder dataHolder = KubernetesDataHolder.getInstance();
        dataHolder.setOutputDir("target" + File.separator + "kubernetes/");
        File resourcesDirectory = new File("src" + File.separator + "test" + File.separator + "resources");
        DeploymentModel deploymentModel = new DeploymentModel();
        deploymentModel.setSingleYAML(false);
        dataHolder.setDeploymentModel(deploymentModel);
        dataHolder.setBalxFilePath(resourcesDirectory.getAbsolutePath() + File.separator + "hello.balx");
    }

    @AfterClass
    public static void tearDown() {
    }

}
