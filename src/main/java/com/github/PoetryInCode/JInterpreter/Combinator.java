package com.github.PoetryInCode.JInterpreter;

import java.util.HashMap;
import java.util.Stack;

public class Combinator {
    Stack<Command> context = new Stack<>();
    HashMap<String,Command> commands = new HashMap<>();
    public Combinator() {}
    public void add(Command command) {
        commands.put(command.key,command);
    }

    /**
     * @param word
     */
    public void load(String word) {
        if(context.empty()) {
            System.out.println("context empty");
            if(commands.containsKey(word)) {
                System.out.println("found command \"" + word + "\"");
                if(!commands.get(word).hasRequirements()) {
                    commands.get(word).evaluate();
                } else {
                    System.out.println("pushed command onto the stack");
                    context.push(commands.get(word));
                }
            } else {
                System.err.println("[ERROR] No command \"" + word + "\"");
            }
        } else if(word.charAt(0) == ']') {
            word = word.substring(1);
            if(commands.containsKey(word)) {
                context.push(commands.get(word));
            } else {
                System.err.println("[ERROR] No command \"" + word + "\"");
            }
        } else {
            System.out.println("not a sub-command");
            if(!context.empty()) {
                System.out.println("context isn't empty");
                if (context.peek().hasRequirements()) {
                    System.out.println("passed " + word);
                    context.peek().passArgument(word);
                    if(!context.peek().hasRequirements()) {
                        context.pop().evaluate();
                        System.out.println("evaluated, no arguments to be fulfilled");
                    } else {
                        for(int i=0; i<context.peek().satisfied.size(); i++) {
                            if(!context.peek().satisfied.get(i)) {
                                System.out.println(context.peek().requirements.get(i) + " is still unsatisfied");
                            }
                        }
                    }
                } else {
                    System.out.println("Evaluating command");
                    context.pop().evaluate();
                }
            }
        }
    }
}
