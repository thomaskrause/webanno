/*
 * Copyright 2020
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
package de.tudarmstadt.ukp.clarin.webanno.api.annotation.layer.behaviors;

import static java.util.Arrays.asList;

import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.select.BootstrapSelect;
import de.tudarmstadt.ukp.clarin.webanno.model.AnchoringMode;
import de.tudarmstadt.ukp.clarin.webanno.model.AnnotationLayer;

public class AnchoringModeSelect
    extends BootstrapSelect<AnchoringMode>
{
    private static final long serialVersionUID = -7730878193827899241L;

    public AnchoringModeSelect(String aId, IModel<AnnotationLayer> aLayerModel)
    {
        super(aId);

        setModel(PropertyModel.of(aLayerModel, "anchoringMode"));
        setChoiceRenderer(new EnumChoiceRenderer<>(this));
        setChoices(asList(AnchoringMode.values()));
    }
}
