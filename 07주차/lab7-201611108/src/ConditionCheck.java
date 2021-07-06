
public class ConditionCheck {
	public ConditionCheck() {}
	public void setCondition(int i)throws ConditionException{
		if ((i!=1)&(i!=2))
			throw new ConditionException("Invalid number");
	}
}