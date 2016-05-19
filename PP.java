// PP.java

import java.util.*;

/*********/
/* Types */
/*********/

abstract class Type {}//Type

class Int extends Type {}//Int

class Bool extends Type {}//Bool

class Array extends Type {

    Type elements;

    Array (Type elements) {
        this.elements = elements;
    }//Array

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
}//PPCte

class PPTrue extends PPExpr {
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPTrue();
	}//toUPP
}//PPTrue

class PPFalse extends PPExpr {
	UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPFalse();
	}//toUPP
}//PPFalse

class PPVar extends PPExpr {

    String name;

    PPVar (String name) {
        this.name = name;
    }//PPVar
    UPPExpr toUPP(ArrayList<String> locals) {
		return new UPPVar(name);
	}//toUPP
}//PPVar

abstract class PPUnOp extends PPExpr {

    PPExpr e;

}//PPUnOp

class PPInv extends PPUnOp {

    PPInv (PPExpr e) {
        this.e = e;
    }//PPInv

    UPPExpr toUPP( ArrayList<String> locals) {
    UPPExpr ne = e.toUPP(locals);
    return new UPPSub(new UPPCte(4),ne);
    }//toUPP

}//PPInv

class PPNot extends PPUnOp {

    PPNot (PPExpr e) {
        this.e = e;
    }//PPNot
    UPPExpr toUPP(ArrayList<String> locals) {
		UPPExpr ne = e.toUPP(locals);
		return new UPPNot(ne);
    }//toUPP
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
       UPPExpr add1=e1.toUPP(locals);
       UPPExpr add2=e2.toUPP(locals);
       return new UPPAdd(add1,add2);
    
    }//toUPP


}//PPAd

class PPSub extends PPBinOp {

    PPSub (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPSub
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr sub1=e1.toUPP(locals);
       UPPExpr sub2=e2.toUPP(locals);
       return new UPPSub(sub1,sub2);
    
    }//toUPP


}//PPSub

class PPMul extends PPBinOp {

    PPMul (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPMul
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr mul1=e1.toUPP(locals);
       UPPExpr mul2=e2.toUPP(locals);
       return new UPPMul(mul1,mul2);
    
    }//toUPP


}//PPMul

class PPDiv extends PPBinOp {

    PPDiv (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPDiv
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr div1=e1.toUPP(locals);
       UPPExpr div2=e2.toUPP(locals);
       return new UPPDiv(div1,div2);
    
    }//toUPP


}//PPDiv

class PPAnd extends PPBinOp {

    PPAnd (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPAnd
    
    UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr and1=e1.toUPP(locals);
       UPPExpr and2=e2.toUPP(locals);
       return new UPPAnd(and1,and2);
    
    }//toUPP


}//PPAnd

class PPOr extends PPBinOp {

    PPOr (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPOr
    
    UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr or1=e1.toUPP(locals);
       UPPExpr or2=e2.toUPP(locals);
       return new UPPOr(or1,or2);
    
    }//toUPP


}//PPOr

class PPLe extends PPBinOp {

    PPLe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLe
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr le1=e1.toUPP(locals);
       UPPExpr le2=e2.toUPP(locals);
       return new UPPLe(le1,le2);
    
    }//toUPP

}//PPLe

class PPLeq extends PPBinOp {

    PPLeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPLeq
    
    UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr leq1=e1.toUPP(locals);
       UPPExpr leq2=e2.toUPP(locals);
       return new UPPLeq(leq1,leq2);
    }//toUPP

}//PPLeq

class PPEq extends PPBinOp {

    PPEq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPEq
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr eq1=e1.toUPP(locals);
       UPPExpr eq2=e2.toUPP(locals);
       return new UPPEq(eq1,eq2);
    
    }//toUPP
    

}//PPEq

class PPNeq extends PPBinOp {

    PPNeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPNeq
    
    UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr ne1=e1.toUPP(locals);
       UPPExpr ne2=e2.toUPP(locals);
       return new UPPNeq(ne1,ne2);
    
    }//toUPP
    

}//PPNeq

class PPGeq extends PPBinOp {

    PPGeq (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGeq
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr geq1=e1.toUPP(locals);
       UPPExpr geq2=e2.toUPP(locals);
       return new UPPGeq(geq1,geq2);
    
    }//toUPP

}//PPGeq

class PPGe extends PPBinOp {

    PPGe (PPExpr e1, PPExpr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//PPGe
    
     UPPExpr toUPP(ArrayList<String> locals) {
       UPPExpr ge1=e1.toUPP(locals);
       UPPExpr ge2=e2.toUPP(locals);
       return new UPPGe(ge1,ge2);
    
    }//toUPP

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

}//PPProcCall
    
class PPSkip extends PPInst {}//PPSkip

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

