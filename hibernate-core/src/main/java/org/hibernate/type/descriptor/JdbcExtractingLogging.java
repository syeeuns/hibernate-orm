/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.type.descriptor;

import org.hibernate.internal.log.SubSystemLogging;

import org.jboss.logging.Logger;

@SubSystemLogging(
		name = JdbcExtractingLogging.NAME,
		description = "Logging of JDBC value extraction"
)
public interface JdbcExtractingLogging {
	String NAME = SubSystemLogging.BASE + ".jdbc.extract";

	Logger LOGGER = Logger.getLogger( NAME );

	boolean TRACE_ENABLED = LOGGER.isTraceEnabled();
	boolean DEBUG_ENABLED = LOGGER.isDebugEnabled();

	static void logExtracted(int jdbcPosition, int typeCode, Object value) {
		assert TRACE_ENABLED;

		JdbcExtractingLogging.LOGGER.tracef(
				"extracted value (%s:%s) -> [%s]",
				jdbcPosition,
				JdbcTypeNameMapper.getTypeName( typeCode ),
				value
		);
	}

	static void logNullExtracted(int jdbcPosition, int typeCode) {
		assert TRACE_ENABLED;

		JdbcExtractingLogging.LOGGER.tracef(
				"extracted value (%s:%s) -> [null]",
				jdbcPosition,
				JdbcTypeNameMapper.getTypeName( typeCode )
		);
	}

	static void logExtracted(String callableParamName, int typeCode, Object value) {
		assert TRACE_ENABLED;

		JdbcExtractingLogging.LOGGER.tracef(
				"extracted value (%s:%s) -> [%s]",
				callableParamName,
				JdbcTypeNameMapper.getTypeName( typeCode ),
				value
		);
	}

	static void logNullExtracted(String callableParamName, int typeCode) {
		assert TRACE_ENABLED;

		JdbcExtractingLogging.LOGGER.tracef(
				"extracted value (%s:%s) -> [null]",
				callableParamName,
				JdbcTypeNameMapper.getTypeName( typeCode )
		);
	}

}
