package cat.pseudocodi.antlr101;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.util.Arrays;

public class TreeUI {

    public static void main(String[] args) {
        String expression = "3 * 2 +  1";
        CalculatorParser parser = Calculator.createParser(expression);
        ParseTree tree = parser.expression();
        System.out.println("String tree = " + tree.toStringTree());

        JFrame frame = new JFrame("AST for expression: " + expression);
        TreeViewer treeViewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        treeViewer.setScale(1.5);
        frame.add(treeViewer);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }
}
