/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.compileflow.engine.process.preruntime.converter.impl.parser.support.tbbpm;

import com.alibaba.compileflow.engine.definition.common.Element;
import com.alibaba.compileflow.engine.definition.common.var.IVar;
import com.alibaba.compileflow.engine.definition.tbbpm.SubBpmNode;
import com.alibaba.compileflow.engine.definition.tbbpm.TbbpmModelConstants;
import com.alibaba.compileflow.engine.process.preruntime.converter.impl.parser.support.AbstractTbbpmElementParser;
import com.alibaba.compileflow.engine.process.preruntime.converter.impl.parser.model.ParseContext;
import com.alibaba.compileflow.engine.process.preruntime.converter.impl.parser.model.XMLSource;

/**
 * @author wuxiang
 * @author yusu
 */
public class SubBpmParser extends AbstractTbbpmElementParser<SubBpmNode> {

    @Override
    protected SubBpmNode doParse(XMLSource xmlSource, ParseContext parseContext) throws Exception {
        SubBpmNode subBpmNode = new SubBpmNode();
        subBpmNode.setId(xmlSource.getString("id"));
        subBpmNode.setName(xmlSource.getString("name"));
        subBpmNode.setTag(xmlSource.getString("tag"));
        subBpmNode.setDescription(xmlSource.getString("description"));
        subBpmNode.setG(xmlSource.getString("g"));
        subBpmNode.setSubBpmCode(xmlSource.getString("subBpmCode"));
        subBpmNode.setType(xmlSource.getString("type"));
        subBpmNode.setWaitForCompletion(xmlSource.getBoolean("waitForCompletion"));
        subBpmNode.setWaitForTrigger(xmlSource.getBoolean("waitForTrigger"));
        return subBpmNode;
    }

    @Override
    protected void attachChildElement(Element childElement, SubBpmNode element, ParseContext parseContext) {
        if (childElement instanceof IVar) {
            element.addVar((IVar)childElement);
        }
    }

    @Override
    public String getName() {
        return TbbpmModelConstants.SUB_BPM;
    }

}
