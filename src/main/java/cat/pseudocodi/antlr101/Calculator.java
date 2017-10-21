package cat.pseudocodi.antlr101;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

class Calculator extends CalculatorBaseVisitor<Integer> {

    static Integer calculate(String expression) {
        CalculatorParser parser = createParser(expression);
        ParseTree tree = parser.expression();
        return new Calculator().visit(tree);
    }

    static CalculatorParser createParser(String expression) {
        CharStream stream = CharStreams.fromString(expression);
        CalculatorLexer lexer = new CalculatorLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        return new CalculatorParser(tokenStream);
    }

    public Integer visitInt(CalculatorParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitAddSub(CalculatorParser.AddSubContext ctx) {
        if (ctx.ADD() != null) {
            return visit(ctx.left) + visit(ctx.right);
        } else {
            return visit(ctx.left) - visit(ctx.right);
        }
    }

    @Override
    public Integer visitMulDiv(CalculatorParser.MulDivContext ctx) {
        if (ctx.MUL() != null) {
            return visit(ctx.left) * visit(ctx.right);
        } else {
            return visit(ctx.left) / visit(ctx.right);
        }
    }

    @Override
    public Integer visitParenthesis(CalculatorParser.ParenthesisContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Integer visitFunction(CalculatorParser.FunctionContext ctx) {
        Integer argument = visit(ctx.func().expression());
        if (ctx.func().funcname().SQR() != null) {
            return argument * argument;
        } else {
            return argument * argument * argument;
        }
    }
}


