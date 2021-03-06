# --------------------------------------------------------------
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
# --------------------------------------------------------------

FROM wso2/base-image:4.1.0
MAINTAINER dev@wso2.org

ENV DEBIAN_FRONTEND noninteractive

ENV PPAAS_VERSION 4.1.0-SNAPSHOT
ENV WSO2_ESB_VERSION 4.8.1
ENV MYSQL_CONNECTOR_VERSION 5.1.36
ENV ESB_TEMPLATE_MODULE_NAME wso2esb-${WSO2_ESB_VERSION}-template-module-${PPAAS_VERSION}
ENV PCA_NAME apache-stratos-python-cartridge-agent-${PPAAS_VERSION}
ENV PCA_HOME /opt/${PCA_NAME}
ENV CARBON_HOME /opt/wso2esb-${WSO2_ESB_VERSION}

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY scripts/init.sh /usr/local/bin/init.sh
COPY packages/${ESB_TEMPLATE_MODULE_NAME}.zip /opt/
COPY packages/wso2esb-${WSO2_ESB_VERSION}.zip /opt/
COPY packages/mysql-connector-java-${MYSQL_CONNECTOR_VERSION}-bin.jar /opt/
COPY plugins /${PCA_HOME}/plugins

# -----------------------------
# Install prerequisites and ESB
# -----------------------------
WORKDIR /opt

RUN unzip /opt/wso2esb-${WSO2_ESB_VERSION}.zip -d /opt/ && \
    rm /opt/wso2esb-${WSO2_ESB_VERSION}.zip && \
    mv /opt/mysql-connector-java-${MYSQL_CONNECTOR_VERSION}-bin.jar /opt/wso2esb-${WSO2_ESB_VERSION}/repository/components/lib && \
    unzip /opt/${ESB_TEMPLATE_MODULE_NAME}.zip -d ${CONFIGURATOR_HOME}/template-modules && \
    rm -rf /opt/${ESB_TEMPLATE_MODULE_NAME}.zip

# ----------------------
# Expose container ports
# ----------------------

# ESB https port
EXPOSE 9443
# ESB http pass-through transport port
EXPOSE 8280
# ESB https pass-through transport port
EXPOSE 8243

# -------------------------------
# Define entry point & start sshd
# -------------------------------

ENTRYPOINT /usr/local/bin/init.sh >> /tmp/init.sh.log 2>&1 | /usr/sbin/sshd -D
