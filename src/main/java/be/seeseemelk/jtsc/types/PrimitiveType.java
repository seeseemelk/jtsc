package be.seeseemelk.jtsc.types;

import java.util.Optional;

public class PrimitiveType implements BaseType
{
	public enum PType
	{
		INTEGER("int"),
		BOOLEAN("bool"),
		ARRAY("[]"),
		OBJECT(""),
		VOID("void");
		
		private String type;
		
		PType(String type)
		{
			this.type = type;
		}
		
		@Override
		public String toString()
		{
			return type;
		}
	};
	
	private PType type;
	private Optional<String> value = Optional.empty();
	
	public PrimitiveType(PType type, String value)
	{
		this.type = type;
		this.value = Optional.of(value);
	}
	
	public PrimitiveType(PType type, long i)
	{
		this(type, Long.toString(i));
	}
	
	public PrimitiveType(PType type)
	{
		this.type = type;
	}
	
	public PrimitiveType(char type)
	{
		this.type = switch(type)
		{
			case 'I' -> PType.INTEGER;
			case 'V' -> PType.VOID;
			case 'Z' -> PType.BOOLEAN;
			case '[' -> PType.ARRAY;
			case 'L' -> PType.OBJECT;
			default -> throw new UnsupportedOperationException("Not a valid option '" + type + "'");
		};
	}
	
	@Override
	public String mangleType()
	{
		return type.toString();
	}
	
	public Optional<String> getValue()
	{
		return value;
	}
	
	@Override
	public String asValue()
	{
		return value.get();
	}
}
