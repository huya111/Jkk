	public void initListener() {
		mBtnLoght.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mBtnLoght.setEnabled(false);
				ShowProgressDialog("登录中");
				String userName = mEtName.getText().toString().trim();
				String passWord= mEtWrod.getText().toString().trim();
				HttpEngine.SERVER_URL="";
				mAppAction.login(userName, passWord, "text", new ActionCallbackListener<AccessToken>() {
					
					@Override
					public void onSuccess(AccessToken data) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "AccessToaken:"+data.getAccessToken(), Toast.LENGTH_SHORT).show();
						HttpEngine.ACCESSTOKEN=data.getAccessToken();
						DismissProgressDialog();
						startActivity(new Intent(MainActivity.this,HomeActivity.class));
						MainActivity.this.finish();
						
					}
					
					@Override
					public void onFailure(String errorEven, String message) {
						// TODO Auto-generated method stub
						DismissProgressDialog();
						ShowToast("错误信息"+message);
						mBtnLoght.setEnabled(true);
					}
				});
				
			}
		});
	}
