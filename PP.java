// PP.java

import java.util.*;

/*********/
/* Types */
/*********/

abstract class Type {}//Type

class Int extends Type {
	String toString(){
		System.out.println("integer");
	}
}//Int

class Bool extends Type {
	String toString(){
		System.out.println("boolean");
	}
}//Bool

class Array extends Type {

    Type elements;

    Array (Type elements) {
        this.elements = elements;
    }//Array
        String toString() {
	System.out.println( "array ( " + elements + " )");
	}


}//Array

/**************************************/
/* Arithmetic and boolean expressions */
/**************************************/

abstract class PPExpr {
	abstract UPPExpr toUPP(ArrayList<String> locals);
}//PPExpr

class PPCte extends PPExpr {

    int val;

    PPCte (int val) {
        this.val = val;
    }//PPCte
    UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPCte(val);
    }	
		
		String toString() {
		System.out.println(Integer.toString(val));
	}
}//PPCte

class PPTrue extends PPExpr {
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPTrue();
	}//toUPP
	String toString(){
		System.out.println("true");
	}
}//PPTrue

class PPFalse extends PPExpr {
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPFalse();
	}//toUPP
	String toString(){
		System.out.println("false");
	}
}//PPFalse

class PPVar extends PPExpr {

    String name;

    PPVar (String name) {
        this.name = name;
    }//PPVar
    UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPVar(name);
	}//toUPP
	
	String toString(){
    	System.out.println(name);
    }
}//PPVar

abstract class PPUnOp extends PPExpr {

    PPExpr e;

}//PPUnOp

class PPInv extends PPUnOp {

    PPInv (PPExpr e) {
        this.e = e;
    }//PPInv

    UPPExpr toUPP( ArrayList<String> locals) {
    return new UPPSub(new UPPCte(0), this.e.toUPP(locals));
    }//toUPP
    
     String toString() {
     	System.out.println("- (" + e + ")");
	}

}//PPInv

class PPNot extends PPUnOp {

    PPNot (PPExpr e) {
        this.e = e;
    }//PPNot
    UPPExpr toUPP(ArrayList<String> locals) {
	return new UPPNot(this.e.toUPP(locals));
    }//toUPP
    
    String toString(){
    	System.out.println("- "+e);
    }
}//PPNot

abstract class PPBinOp extends PPExpr {

    PPExpr e1, e2;

}//PPBinOp

class PPAdd extends PPBinOp {

    PPAdd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAdd
    
     UPPExpr toUPP(ArrayList<String> locals) {
      return new UPPAdd(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
    
    String toString(){
		System.out.println(e1+" + "+e2);
	}


}//PPAd

class PPSub extends PPBinOp {

    PPSub (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPSub
    
     UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPSub(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
   String toString(){
		System.out.println(e1+" - "+e2);
	}

}//PPSub

class PPMul extends PPBinOp {

    PPMul (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPMul
    
     UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPMul(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
  String toString(){
		System.out.println(e1+" * "+e2);
	}

}//PPMul

class PPDiv extends PPBinOp {

    PPDiv (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPDiv
    
     UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPDiv(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
                String toString(){
		System.out.println(e1+" / "+e2);
	}

}//PPDiv

class PPAnd extends PPBinOp {

    PPAnd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAnd
    
    UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPAnd(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
String toString(){
		System.out.println(e1+" and "+e2);
	}

}//PPAnd

class PPOr extends PPBinOp {

    PPOr (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPOr
    
    UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPOr(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
  String toString(){
		System.out.println(e1+" or "+e2);
	}

}//PPOr

class PPLe extends PPBinOp {

    PPLe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLe
    
     UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPLe(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
    String toString(){
		System.out.println(e1+" < "+e2);
	}

}//PPLe

class PPLeq extends PPBinOp {

    PPLeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLeq
    
    UPPExpr toUPP(ArrayList<String> locals) {
      return new UPPLeq(this.e1.toUPP(locals), this.e2.toUPP(locals));
    }//toUPP
    
    String toString(){
		System.out.println(e1+" <= "+e2);
	}

}//PPLeq

class PPEq extends PPBinOp {

    PPEq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPEq
    
     UPPExpr toUPP(ArrayList<String> locals) {
      return new UPPEq(this.e1.toUPP(locals), this.e2.toUPP(locals));
    }//toUPP
    String toString(){
		System.out.println(e1+" = "+e2);
	}

}//PPEq

class PPNeq extends PPBinOp {

    PPNeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPNeq
    
    UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPNeq(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
    String toString(){
		System.out.println(e1+" != "+e2);
	}

}//PPNeq

class PPGeq extends PPBinOp {

    PPGeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGeq
    
     UPPExpr toUPP(ArrayList<String> locals) {
      return new UPPGeq(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
    public String toString() {
		return ">= (" + e1 + ") (" + e2 + ")";
	}


}//PPGeq

class PPGe extends PPBinOp {

    PPGe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGe
    
     UPPExpr toUPP(ArrayList<String> locals) {
       return new UPPGe(this.e1.toUPP(locals), this.e2.toUPP(locals));
    
    }//toUPP
    String toString(){
		System.out.println(e1+" > "+e2);
	}

}//PPGe

abstract class Callee {}//Callee

class Read extends Callee {}//Read

class Write extends Callee {}//Write

class User extends Callee {

    String name;

    User (String name) {
        this.name = name;
    }//User

}//User

class PPFunCall extends PPExpr {

    Callee callee;
    ArrayList<PPExpr> args;

    PPFunCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//FunCall
    UPPExpr toUPP(ArrayList<String> locals) {
		ArrayList<UPPExpr> argsUPP = new ArrayList<UPPExpr>();
		for(PPExpr arg : args){
			argsUPP.add(arg.toUPP(locals));
		}
		return new UPPFunCall(callee,argsUPP);
	}//toUPP
	String toString(){
		System.out.println(callee+"("+args+")");
	}
}//FunCall

class PPArrayGet extends PPExpr {

    PPExpr arr, index;

    PPArrayGet (PPExpr arr, PPExpr index) {
        this.arr = arr;
        this.index = index;
    }//PPArrayGet

    UPPExpr toUPP(ArrayList<String> locals){
      UPPExpr narr=arr.toUPP(locals),nindex=index.toUPP(locals);
      UPPExpr offset= new UPPMul(new UPPCte(4),nindex);
      return new UPPLoad(new UPPAdd(narr,offset));
}//toUPP

      String toString() {
      	System.out.println(arr + " (" + index + ")");
	}

}//PPArrayGet

class PPArrayAlloc extends PPExpr {

    Type type;
    PPExpr size;

    PPArrayAlloc (Type type, PPExpr size) {
        this.type = type;
        this.size = size;
    }//PPArrayAlloc

    UPPExpr toUPP(ArrayList<String> locals){
        UPPExpr nsize=size.toUPP(locals);
        UPPExpr sizeBytes= new UPPMul(new UPPCte(4),nsize));
        ArrayList<UPPExpr> args = new ArrayList<UPPExpr>();
        args.add(sizeBytes);
        return new UPPFunCall (new Alloc (),args);
    }//toUPP
    String toString() {
    System.out.println("new array (" + type + ") (" + size + ")");
	}

}//PPArrayAlloc

/****************/
/* Instructions */
/****************/

abstract class PPInst {
	abstract UPPInst toUPP(ArrayList<String> locals);
}//PPInst

class PPAssign extends PPInst {

    String name;
    PPExpr val;

    PPAssign (String name, PPExpr val) {
        this.name = name;
        this.val = val;
    }//PPAssign
    
    UPPInst toUPP(ArrayList<String> locals){
      UPPExpr nval=val.toUPP(locals);
      return new UPPAssign(name,nval);
    
    }//toUPP
    String toString() {
    	System.out.println("= (" + name + ") (" + val + ")");
	}

}//PPAssign

class PPArraySet extends PPInst {

    PPExpr arr, index, val;

    PPArraySet (PPExpr arr, PPExpr index, PPExpr val) {
        this.arr = arr;
        this.index = index;
        this.val = val;
    }//PPArraySet
    UPPInst toUPP(ArrayList<String> locals){
    	UPPExpr narr = arr.toUPP(locals);
    	UPPExpr nindex = index.toUPP(locals);
    	UPPExpr nval = val.toUPP(locals);
    	UPPExpr offset = new UPPMul(new UPPCte(4),nindex);
    	UPPExpr nsize = new UPPAdd(narr,offset);
    	return new UPPStore(narr,new UPPMul(nsize,nval));
    }
    String toString() {
		System.out.println("= (" + arr + " (" + index + ") ) (" + val + ")");
	}
}//PPArraySet

class PPCond extends PPInst {

    PPExpr cond;
    PPInst i1, i2;

    PPCond (PPExpr cond, PPInst i1, PPInst i2) {
        this.cond = cond;
        this.i1 = i1;
        this.i2 = i2;
    }//PPCond
    UPPInst toUPP(ArrayList<String> locals){
    	UPPExpr ncond = cond.toUPP(locals);
    	UPPInst ni1 = i1.toUPP(locals);
    	UPPInst ni2 = i2.toUPP(locals);
    	return new UPPCond(ncond, ni1,ni2);
    }
    String toString() {
		System.out.println("if (" + ncond + ") (" + ni1 + ") (" + ni2 + ")");
	}
}//PPCond

class PPWhile extends PPInst {

    PPExpr cond;
    PPInst i;

    PPWhile (PPExpr cond, PPInst i) {
        this.cond = cond;
        this.i = i;
    }//PPWhile
    
    UPPInst toUPP(ArrayList<String> locals){
      UPPExpr ncond=cond.toUPP(locals);
      UPPInst ni=i.toUPP(locals);
      return new UPPWhile(ncond, ni);
    }
    String toString() {
  System.out.println("while (" + ncond + ") (" + ni + ")");
	}

}//PPWhile

class PPProcCall extends PPInst {

    Callee callee;
    ArrayList<PPExpr> args;

    PPProcCall (Callee callee, ArrayList<PPExpr> args) {
        this.callee = callee;
        this.args = args;
    }//PPProcCall

  UPPInst toUPP(ArrayList<String> locals){
  ArrayList<UPPExpr> nargs= new ArrayList<UPPExpr>(); 
  for PPExpr e:args
  nargs.add(e.toUPP(locals)) ;
  return new UPPProcCall(callee,nargs);
}//toUPP
String toString(){
		System.out.println("("+nargs+")\n"+callee);
	}

}//PPProcCall
    
class PPSkip extends PPInst {

	UPPInst toUPP(ArrayList<String> locals) {
		// TODO Auto-generated method stub
		return null;
	}//PPSkip
	String toString() {
		System.out.println("skip");
	}
	
}//PPSkip

class PPSeq extends PPInst {

    PPInst i1, i2;

    PPSeq (PPInst i1, PPInst i2) {
        this.i1 = i1;
        this.i2 = i2;
    }//PPSeq
    UPPInst toUPP(ArrayList<String> locals){
    	UPPInst ni1 = i1.toUPP(locals);
    	UPPInst ni2 = i2.toUPP(locals);
    	return new UPPSeq(ni1, ni2);
    }
    String toString() {
	System.out.println("(" + i1 + ") (" + i2 + ")");
	}
}//PPSeq

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

abstract class PPDef {

    String name;
    ArrayList<Pair<String,Type>> args, locals;
    PPInst code;

    abstract  UPPDef toUPP(); 	
}//PPDef

class PPFun extends PPDef {

    Type ret;

    PPFun (String name, ArrayList<Pair<String,Type>> args,
         ArrayList<Pair<String,Type>> locals, PPInst code, Type ret) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
        this.ret = ret;
    }//PPFun
    
    UPPDef toUPP(){
    	ArrayList<String> nargs = new ArrayList<String>();
    	ArrayList<String> nlocals = new ArrayList<String>();
    	ArrayList<String> nall = new ArrayList<String>();
    	UPPInst ncode;
    	for(Pair <String,Type> e : args){
    		nargs.add(e.left);
    		nall.add(e.left);
    	}//for
    	
    	for(Pair <String,Type> e : locals){
    		nlocals.add(e.left);
    		nall.add(e.left);
    	}//for
    	
    	ncode = code.toUPP(nall);
    	return new UPPFun(name,nargs,nlocals,ncode);
}//toUPP
String toString(){
		System.out.println(name+"("+args+")\n"+locals+"\n"+code);
	}
}//PPFun

class PPProc extends PPDef {

    PPProc (String name, ArrayList<Pair<String,Type>> args,
            ArrayList<Pair<String,Type>> locals, PPInst code) {
        this.name = name;
        this.args = args;
        this.locals = locals;
        this.code = code;
    }//PPProc
    
    UPPDef toUPP(){
      ArrayList<String> nargs= new ArrayList<String>;
      ArrayList<String> nlocals= new ArrayList<String>;
      ArrayList<String> nall= new ArrayList<String>;
      
      UPPInst ncode;
      for(Pair<String,Type> e:args){
        nargs.add(e.left);
        nall.add(e.left);
      }//for
      for(Pair<String,Type> e:args){
        nargs.add(e.left);
        nall.add(e.left);
      }//for
      ncode=code.toUPP(nall);
      return new UPPProc(name,nargs,nlocals,ncode);
    
    }//toUPP
    String toString(){
		System.out.println(name+"("+nargs+")\n"+nlocals+"\n"+ncode);
	}

}//PPProc

/************/
/* Programs */
/************/

class PPProg {

    ArrayList<Pair<String,Type>> globals;
    ArrayList<PPDef> defs;
    PPInst code;

    PPProg (ArrayList<Pair<String,Type>> globals, ArrayList<PPDef> defs,
          PPInst code) {
        this.globals = globals;
        this.defs = defs;
        this.code = code;
    }//PPProg

    UPPProg toUPP(){
      ArrayList<String> nglobals= new ArrayList<String>();
      ArrayList<UPPDef> ndefs= new ArrayList<UPPDef>();
      UPPInst ncode;
      for(Pair<String,Type> e:globals)
        nglobals.add(e.left);
      for(PPDef e:defs)
        ndefs.add(e.toUPP());           
      ncode=code.toUPP(new ArrayList<String>());
      return new UPPProg(nglobals, ndefs,ncode);
      
}//toUPP
String toString(){
		System.out.println(nglobals+"\n"+ndefs+"\n"+ncode);
	}
}//PPProg	
	

