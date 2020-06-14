package my.language.interpreter;

import java.util.*;

public abstract class Command {
    protected static HashMap<String,Object> sysReq_val = new HashMap<>();
    private static List<Boolean> sysReq_sat = new ArrayList<>();
    public static List<String> sysReq = new ArrayList<>();

    public List<String> requirements = new ArrayList<>();
    protected List<Boolean> satisfied = new ArrayList<>();
    protected HashMap<String, String> values = new HashMap<>();

    public String key;

    public Command(String word) {
        this.key = word;
    }
    public static void addSysReq(String key) {
        if(!sysReq.contains(key)) {
            sysReq.add(key);
        }
    }

    public static void setSysReq(String key, Object value) {
        for(int i=0; i<sysReq.size(); i++) {
            if(!sysReq_val.containsKey(sysReq.get(i))) {
                sysReq_val.put(key, value);
                sysReq_sat.set(i,true);
            }
        }
    }
    public static Object getSysVal(String key) {
        if(sysReq_val.containsKey(key)) {
            return sysReq_val.get(key);
        } else {
            try {
                throw new NoSuchFieldException("[ERROR] Could not find global system requirement \"" + key +"\" to replace");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    boolean hasRequirements() {
        boolean state = false;
        for(Boolean a:satisfied) {
            if(!a) {
                state = true;
                break;
            }
        }
        for(Boolean a:sysReq_sat) {
            if(!a) {
                state = true;
                break;
            }
        }
        return state;
    }

    void passArgument(String word) {
        for(int i=0; i<requirements.size(); i++) {//iterate through requirements
            if(!satisfied.get(i)) {//if an argument isn't satisfied
                System.out.println("arg " + i + " isn't satisfied");
                values.put(requirements.get(i),word);//add the requirement as the key and the word as the value
                satisfied.set(i,true);//mark the argument satisfied
                System.out.println("it should be now");
                break;
            }
        }
    }

    public Command bake() {
        this.require();
        if(requirements.size() != satisfied.size()) {
            for(int i=0; i<requirements.size()-satisfied.size(); i++) {
                System.err.println("Unsatisfied command requirement");
                satisfied.add(false);
            }
        }
        if(sysReq.size() != sysReq_sat.size()) {
            for(int i=0; i<sysReq.size()-sysReq_sat.size(); i++) {
                System.err.println("Unsatisfied system requirement");
                sysReq_sat.add(false);
            }
        }
        return this;
    }

    public void evaluate() {
        this.evaluation();
        System.out.println("evaluating");
        for(int i=0; i<requirements.size(); i++) {
            satisfied.set(i,false);
        }
    }

    protected abstract void require();
    protected abstract void evaluation();
}
