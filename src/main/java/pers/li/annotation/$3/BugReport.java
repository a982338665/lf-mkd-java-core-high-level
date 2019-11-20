package pers.li.annotation.$3;

public @interface BugReport {
	enum Status {UNCONFIRMED, CONFIRMED, FIXED, NOTABUG};
	boolean showStopper() default true;
	String assiganedTo() default "[none]";
	Status status() default Status.UNCONFIRMED;
	String[] reportedBy();
}
