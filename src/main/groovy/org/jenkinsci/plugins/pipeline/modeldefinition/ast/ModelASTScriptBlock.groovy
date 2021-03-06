/*
 * The MIT License
 *
 * Copyright (c) 2016, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.pipeline.modeldefinition.ast

import groovy.transform.ToString
import org.jenkinsci.plugins.pipeline.modeldefinition.steps.ScriptStep

/**
 * Represents the special step for {@link ScriptStep}, which are executed without validation against the declarative subset.
 *
 * @author Andrew Bayer
 */
@ToString(includeSuper = true, includeSuperProperties = true)
public class ModelASTScriptBlock extends ModelASTStep {
    // TODO: Maybe rewrite further to be more consistent with the single-parameter-constructor model.
    ModelASTScriptBlock(Object sourceLocation) {
        super(sourceLocation)
        this.name = "script"
    }

    @Override
    public String toGroovy() {
        return "script {\n${args.toGroovy()}\n}\n"
    }
}
