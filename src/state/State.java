//package state;
////b.c
//public abstract class State {
//  protected boolean isPaused;
//  
//  private int menit;
//  
//  private int detik;
//  
//  protected int repetisi;
//  
//  public State() {
//    this.repetisi = 0;
//    this.isPaused = false;
//  }
//  
//  public State(boolean paramBoolean, int paramInt) {
//    this.isPaused = paramBoolean;
//    this.repetisi = paramInt;
//  }
//  
//  
//  public final boolean getIsPaused() {
//    return this.isPaused;
//  }
//  
//  public final void toPlay() {
//    this.isPaused = !this.isPaused;
//  }
//  
//  public final void a(int menit, int detik) {
//    this.menit = menit;
//    this.detik = detik;
//  }
//  
//  public final int getMenit() {
//    return this.menit;
//  }
//  
//  public final int getDetik() {
//    return this.detik;
//  }
//  
//  public final int getRepetisi() {
//    return this.repetisi;
//  }
//  
//  public final String g() {
//    return String.format("%02d:%02d", new Object[] { Integer.valueOf(this.menit), Integer.valueOf(this.detik) });
//  }
//  
//  public abstract State getState();
//}
