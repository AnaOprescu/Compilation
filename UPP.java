// UPP.java

import java.util.*;

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class UPPExpr {}//UPPExpr

class UPPCte extends UPPExpr {

    int val;

    UPPCte (int val) {
        this.val = val;
    }//UPPCte
    String toString(){
    	System.out.println(val);
    }
}//UPPCte

class UPPTrue extends UPPExpr {
    String toString(){
		System.out.println("true");
	}
}//UPPTrue

class UPPFalse extends UPPExpr {
    String toString(){
		System.out.println("false");
	}
}//UPPFalse

class UPPVar extends UPPExpr {

    String name;

    UPPVar (String name) {
        this.name = name;
    }//UPPVar
    String toString(){
    	System.out.println(name);
    }
}//UPPVar

class UPPGVar extends UPPExpr {

    String name;

    UPPGVar (String name) {
        this.name = name;
    }//UPPGVar
    String toString(){
    	System.out.println(name);
    }
}//UPPGVar

abstract class UPPUnOp extends UPPExpr {

    UPPExpr e;

}//UPPUnOp

class UPPInv extends UPPUnOp {

    UPPInv (UPPExpr e) {
        this.e = e;
    }//UPPInv
    String toString(){
    	System.out.println(e);
    }
}//UPPInv

class UPPNot extends UPPUnOp {

    UPPNot (UPPExpr e) {
        this.e = e;
    }//UPPNot
    String toString(){
    	System.out.println("- "+e);
    }
}//UPPNot

abstract class UPPBinOp extends UPPExpr {

    UPPExpr e1, e2;

}//UPPBinOp

class UPPAdd extends UPPBinOp {

    UPPAdd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAdd
    String toString(){
		System.out.println(e1+" + "+e2);
	}
}//UPPAd

class UPPSub extends UPPBinOp {

    UPPSub (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPSub
    String toString(){
		System.out.println(e1+" - "+e2);
	}
}//UPPSub

class UPPMul extends UPPBinOp {

    UPPMul (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPMul
    String toString(){
		System.out.println(e1+" * "+e2);
	}
}//UPPMul

class UPPDiv extends UPPBinOp {

    UPPDiv (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPDiv
     String toString(){
		System.out.println(e1+" / "+e2);
	}
}//UPPDiv

class UPPAnd extends UPPBinOp {

    UPPAnd (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPAnd
     String toString(){
		System.out.println(e1+" and "+e2);
	}
}//UPPAnd

class UPPOr extends UPPBinOp {

    UPPOr (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPOr
    String toString(){
		System.out.println(e1+" or "+e2);
	}
}//UPPOr

class UPPLe extends UPPBinOp {

    UPPLe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLe
    String toString(){
		System.out.println(e1+" < "+e2);
	}
}//UPPLe

class UPPLeq extends UPPBinOp {

    UPPLeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPLeq
    String toString(){
		System.out.println(e1+" <= "+e2);
	}
}//UPPLeq

class UPPEq extends UPPBinOp {

    UPPEq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPEq
    String toString(){
		System.out.println(e1+" = "+e2);
	}
}//UPPEq

class UPPNeq extends UPPBinOp {

    UPPNeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPNeq
    String toString(){
		System.out.println(e1+" != "+e2);
	}
}//UPPNeq

class UPPGeq extends UPPBinOp {

    UPPGeq (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGeq
    String toString(){
		System.out.println(e1+" >= "+e2);
	}
}//UPPGeq

class UPPGe extends UPPBinOp {

    UPPGe (UPPExpr e1, UPPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//UPPGe
    String toString(){
		System.out.println(e1+" > "+e2);
	}
}//UPPGe

class Alloc extends Callee {}//Alloc

class UPPFunCall extends UPPExpr {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPFunCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall
     String toString(){
		System.out.println(callee+"("+args+")");
	}
}//FunCall

class UPPLoad extends UPPExpr {

    UPPExpr addr;

    UPPLoad (UPPExpr addr) {
        this.addr = addr;
    }//UPPLoad
     String toString(){
		System.out.println(addr);
	}
}//UPPLoad

/****************/
/* Instructions */
/****************/

abstract class UPPInst {}//UPPInst

class UPPAssign extends UPPInst {

    String name;
    UPPExpr val;

    UPPAssign (String name, UPPExpr val) {
        this.name = name;
        this.val = val;
    }//UPPAssign
    String toString(){
		System.out.println(name+" := "+val);
	}
}//UPPAssign

class UPPStore extends UPPInst {

    UPPExpr addr, val;

    UPPStore (UPPExpr addr, UPPExpr val) {
        this.addr = addr;
        this.val = val;
    }//UPPStore
    String toString(){
		System.out.println(addr+" = "+val);
	}
}//UPPStore

class UPPCond extends UPPInst {

    UPPExpr cond;
    UPPInst i1, i2;

    UPPCond (UPPExpr cond, UPPInst i1, UPPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//UPPCond
    String toString(){
		System.out.println("if "+i1+" then "+i2);
	}
}//UPPCond

class UPPWhile extends UPPInst {

    UPPExpr cond;
    UPPInst i;

    UPPWhile (UPPExpr cond, UPPInst i) {
        this.cond = cond;
        this.i = i;
    }//UPPWhile
    String toString(){
		System.out.println("while "+i+" do");
	}
}//UPPWhile

class UPPProcCall extends UPPInst {

    Callee callee;
    ArrayList<UPPExpr> args;

    UPPProcCall (Callee callee, ArrayList<UPPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//UPPProcCall
    String toString(){
		System.out.println(callee+"("+args+")");
	}
}//UPPProcCall
    
class UPPSkip extends UPPInst {}//UPPSkip

class UPPSeq extends UPPInst {

    UPPInst i1, i2;

    UPPSeq (UPPInst i1, UPPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//UPPSeq
    String toString(){
		System.out.println(i1+""+i2);
	}
}//UPPSeq

/***************************************/
/* Definitions of functions/procedures */
/***************************************/

class Pair<L,R> {

    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }//Pair

    static <L,R> Pair<L,R> of(L left, R right){
        return new Pair<L,R>(left, right);
    }//of

}//Pair

abstract class UPPDef {

    String name;
    ArrayList<String> args, locals;
    UPPInst code;
    abstract String toString();
}//UPPDef

class UPPFun extends UPPDef {

    UPPFun (String name, ArrayList<String> args, ArrayList<String> locals,
            UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPFun
    String toString(){
		System.out.println(name+"("+args+")\n"+locals+"\n"+code);
	}
}//UPPFun

class UPPProc extends UPPDef {

    UPPProc (String name, ArrayList<String> args, ArrayList<String> locals,
             UPPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//UPPProc
     String toString(){
		System.out.println(name+"("+args+")\n"+locals+"\n"+code);
	}
}//UPPProc

/************/
/* Programs */
/************/

class UPPProg {

    ArrayList<String> globals;
    ArrayList<UPPDef> defs;
    UPPInst code;

    UPPProg (ArrayList<String> globals, ArrayList<UPPDef> defs, UPPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//UPPProg
     String toString(){
		System.out.println(globals+"\n"+defs+"\n"+code);
	}
}//UPPProg
