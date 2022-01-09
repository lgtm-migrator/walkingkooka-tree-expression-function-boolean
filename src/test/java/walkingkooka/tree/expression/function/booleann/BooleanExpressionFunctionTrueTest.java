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

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

public final class BooleanExpressionFunctionTrueTest extends BooleanExpressionFunctionTestCase<BooleanExpressionFunctionTrue<ExpressionFunctionContext>> {

    @Test
    public void testExecuteFunction() {
        this.applyAndCheck2(parameters(), Boolean.TRUE);
    }

    @Test
    public void testResolveReferencesTrue() {
        this.resolveReferencesAndCheck(true);
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "true");
    }

    @Override
    public BooleanExpressionFunctionTrue<ExpressionFunctionContext> createBiFunction() {
        return BooleanExpressionFunctionTrue.instance();
    }

    @Override
    public Class<BooleanExpressionFunctionTrue<ExpressionFunctionContext>> type() {
        return Cast.to(BooleanExpressionFunctionTrue.class);
    }
}
