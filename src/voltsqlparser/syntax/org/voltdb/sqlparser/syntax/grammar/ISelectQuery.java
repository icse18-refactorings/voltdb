package org.voltdb.sqlparser.syntax.grammar;

import java.util.List;

import org.voltdb.sqlparser.syntax.symtab.IAST;
import org.voltdb.sqlparser.syntax.symtab.ISymbolTable;
import org.voltdb.sqlparser.syntax.symtab.ITable;

/**
 * This holds all the parts of a select statement.
 *
 * @author bwhite
 */
public interface ISelectQuery {

	void addProjection(String aTableName, String aColumnName, String aAlias);

	void pushNeutrino(INeutrino aColumnNeutrino);

	INeutrino popNeutrino();

	String printProjections();

	String printNeutrinos();

	void addTable(ITable aITable, String aAlias);

	String printTables();

	boolean hasNeutrinos();

	INeutrino getColumnNeutrino(String aColumnName, String aTableName);

	List<Projection> getProjections();

    void setWhereCondition(INeutrino aRet);

    IAST getWhereCondition();

    ISymbolTable getTables();

    void setAST(IAST aMakeQueryAST);
	INeutrino getNeutrinoMath(IOperator aOperator, INeutrino aLeftoperand,
			INeutrino aRightoperand);

	INeutrino getNeutrinoCompare(IOperator aOperator, INeutrino aLeftoperand,
			INeutrino aRightoperand);

	INeutrino getNeutrinoBoolean(IOperator aOperator, INeutrino aLeftoperand,
			INeutrino aRightoperand);

}
