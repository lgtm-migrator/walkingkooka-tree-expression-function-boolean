/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
 *
 */

package walkingkooka.tree.expression.function.booleann;

import walkingkooka.Cast;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterKind;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.util.List;

/**
 * Uses the first number as an index to select one of the values in following parameters.
 * <br>
 * https://exceljet.net/excel-functions/excel-choose-function
 */
final class ObjectExpressionFunctionChoose<C extends ExpressionEvaluationContext> extends ObjectExpressionFunction<C> {

    /**
     * Instance getter.
     */
    static <C extends ExpressionEvaluationContext> ObjectExpressionFunctionChoose<C> instance() {
        return Cast.to(INSTANCE);
    }

    /**
     * Singleton
     */
    private static final ObjectExpressionFunctionChoose INSTANCE = new ObjectExpressionFunctionChoose();

    /**
     * Private ctor
     */
    private ObjectExpressionFunctionChoose() {
        super("choose");
    }

    @Override
    public Object apply(final List<Object> parameters,
                        final C context) {
        this.checkParameterCount(parameters);

        final int index = INDEX.getOrFail(parameters, 0)
                .intValue();

        return VALUES.getVariable(parameters, 1).get(index - 1);
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<ExpressionNumber> INDEX = ExpressionFunctionParameterName.with("index")
            .required(ExpressionNumber.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_FLATTEN_RESOLVE_REFERENCES);

    private final static ExpressionFunctionParameter<Object> VALUES = ExpressionFunctionParameterName.with("values")
            .variable(Object.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_FLATTEN_RESOLVE_REFERENCES);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            INDEX,
            VALUES
    );
}
