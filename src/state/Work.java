//package state;
//
//public class Work extends State{
//
//	public Work() {
//		// TODO Auto-generated constructor stub
//		Work w;
//		(w = this).a(25,0);
//	}
//	  
//	  public Work(boolean paramBoolean, int paramInt) {
//	    super(paramBoolean, paramInt);
//	    Work w;
//	    (w = this).a(25, 0);
//	  }
//
//	@Override
//	public State getState() {
//		// TODO Auto-generated method stub
//		  this.repetisi++;
//		    return (State)((this.repetisi == 4) ? new LongRest(this.isPaused, this.repetisi) : new ShortRest(this.isPaused, this.repetisi));
//	}
//
//}
//
//
///* Location:              D:\Downloads\project\pomodoro.jar!\b\d.class
// * Java compiler version: 11 (55.0)
// * JD-Core Version:       1.1.3
// */