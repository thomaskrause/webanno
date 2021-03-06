/*
 * Copyright 2019
 * Ubiquitous Knowledge Processing (UKP) Lab and FG Language Technology
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.clarin.webanno.api.annotation.feature;

import java.io.Serializable;

import org.apache.uima.cas.CAS;
import org.apache.uima.resource.metadata.TypeDescription;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.springframework.beans.factory.InitializingBean;

import de.tudarmstadt.ukp.clarin.webanno.model.AnnotationFeature;

public abstract class UimaPrimitiveFeatureSupport_ImplBase<T>
    implements FeatureSupport<T>, InitializingBean
{
    private String featureSupportId;
    
    @Override
    public String getId()
    {
        return featureSupportId;
    }
    
    @Override
    public void setBeanName(String aBeanName)
    {
        featureSupportId = aBeanName;
    }

    @Override
    public Serializable wrapFeatureValue(AnnotationFeature aFeature, CAS aCAS, Object aValue)
    {
        return (Serializable) aValue;
    }
    
    @Override
    public <V> V  unwrapFeatureValue(AnnotationFeature aFeature, CAS aCAS, Object aValue)
    {
        return (V) aValue;
    }
    
    @Override
    public void generateFeature(TypeSystemDescription aTSD, TypeDescription aTD,
            AnnotationFeature aFeature)
    {
        aTD.addFeature(aFeature.getName(), aFeature.getDescription(), aFeature.getType());
    }

    @Override
    public String renderFeatureValue(AnnotationFeature aFeature, String aLabel)
    {
        if (CAS.TYPE_NAME_BOOLEAN.equals(aFeature.getType()) && aLabel != null) {
            if ("true".equals(aLabel)) {
                return "+" + aFeature.getUiName();
            }
            else {
                return "-" + aFeature.getUiName();
            }
        }
        else {
            return FeatureSupport.super.renderFeatureValue(aFeature, aLabel);
        }
    }
}
