/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.ast.spi;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.sql.ast.SqlAstTranslator;
import org.hibernate.sql.ast.SqlAstTranslatorFactory;
import org.hibernate.sql.ast.tree.Statement;
import org.hibernate.sql.ast.tree.delete.DeleteStatement;
import org.hibernate.sql.ast.tree.insert.InsertStatement;
import org.hibernate.sql.ast.tree.select.SelectStatement;
import org.hibernate.sql.ast.tree.update.UpdateStatement;
import org.hibernate.sql.exec.spi.JdbcOperation;
import org.hibernate.sql.exec.spi.JdbcOperationQueryDelete;
import org.hibernate.sql.exec.spi.JdbcOperationQueryInsert;
import org.hibernate.sql.exec.spi.JdbcOperationQuerySelect;
import org.hibernate.sql.exec.spi.JdbcOperationQueryUpdate;
import org.hibernate.sql.model.ast.TableMutation;
import org.hibernate.sql.model.jdbc.JdbcMutationOperation;

/**
 * Standard implementation of SqlAstTranslatorFactory
 *
 * @author Steve Ebersole
 */
public class StandardSqlAstTranslatorFactory implements SqlAstTranslatorFactory {

	@Override
	public SqlAstTranslator<JdbcOperationQuerySelect> buildSelectTranslator(SessionFactoryImplementor sessionFactory, SelectStatement statement) {
		return buildTranslator( sessionFactory, statement );
	}

	@Override
	public SqlAstTranslator<JdbcOperationQueryDelete> buildDeleteTranslator(SessionFactoryImplementor sessionFactory, DeleteStatement statement) {
		return buildTranslator( sessionFactory, statement );
	}

	@Override
	public SqlAstTranslator<JdbcOperationQueryInsert> buildInsertTranslator(SessionFactoryImplementor sessionFactory, InsertStatement statement) {
		return buildTranslator( sessionFactory, statement );
	}

	@Override
	public SqlAstTranslator<JdbcOperationQueryUpdate> buildUpdateTranslator(SessionFactoryImplementor sessionFactory, UpdateStatement statement) {
		return buildTranslator( sessionFactory, statement );
	}

	@Override
	public <O extends JdbcMutationOperation> SqlAstTranslator<O> buildModelMutationTranslator(TableMutation<O> mutation, SessionFactoryImplementor sessionFactory) {
		return buildTranslator( sessionFactory, mutation );
	}

	/**
	 * Consolidated building of a translator for all Query cases
	 */
	protected <T extends JdbcOperation> SqlAstTranslator<T> buildTranslator(SessionFactoryImplementor sessionFactory, Statement statement) {
		return new StandardSqlAstTranslator<>( sessionFactory, statement );
	}

}
