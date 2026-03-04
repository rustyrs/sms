package model.bean;

public class Log implements java.io.Serializable {
	
	// コンストラクタ
	public Log() {}
	public Log(
			String userId, String actionType, String targetTable
	) {
		this.userId = userId;
		this.actionType = actionType;
		this.targetTable = targetTable;
	}
	
	// データ
	private int logId;
	private String userId;
	private String actionType;
	private String targetTable;
	private String actionedAt;

	// ゲッター
	public int getLogId() {
		return logId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getActionType() {
		return actionType;
	}
	
	public String getTargetTable() {
		return targetTable;
	}
	
	public String getActionedAt() {
		return actionedAt;
	}
	
	// セッター	
	public void setLogId(int logId) {
		this.logId = logId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}
	
	public void setActionedAt(String actionedAt) {
		this.actionedAt = actionedAt;
	}
}
