$(function() {

	// 单击事件
	$("#ajaxFind").click(function() {

		var id = $("#cityid").val();
		$.ajax({
			url : "your/city/" + id,
			data : {
				"id" : id
			},
			type : "get",
			dataType : "json",
			success : function(data) {
				$("#c1").html("名称：" + data.cityName);
				$("#c2").html("描述：" + data.description);
				$("#c2").show();

			},
			error : function() {
				$("#c1").html("查询失败");
				$("#c2").hide();
			}
		});

	});

	// 单击事件
	$("#ajaxDel").click(function() {

		var id = $("#cityid").val();

		if (id!="" && confirm("您确定要删除吗?")) {

			$.ajax({
				url : "your/city/" + id,
				data : {
					"id" : id
				},
				type : "delete",
				dataType : "json",
				success : function(data) {
					$("#c2").show();
				},
				error : function() {
					$("#c2").hide();
				}
			});
		}

	});
	// 单击事件
	$("#ajaxAdd").click(function() {

		// json数据
		var city = {
			"provinceId" : $("#pid").val(),
			"cityName" : $("#uname").val(),
			"description" : $("#desc").val()
		};
		$.ajax({
			url : "your/city",
			data : JSON.stringify(city),
			type : "post",
			contentType : 'application/json;charset=utf-8', // 指定类型
			dataType : JSON.stringify(city), //
			success : function(data) {
				$("#c2").show();
			},
			error : function() {
				$("#c2").hide();
			}
		});

	});
	// 单击事件
	$("#ajaxPut").click(function() {

		// json数据
		var city = {
			"id" : $("#cid").val(),
			"provinceId" : $("#ppid").val(),
			"cityName" : $("#puname").val(),
			"description" : $("#pdesc").val()
		};

		$.ajax({
			url : "your/city",
			data : JSON.stringify(city),
			type : "put",
			contentType : 'application/json;charset=utf-8', // 指定类型
			dataType : JSON.stringify(city), //
			success : function(data) {
				$("#c2").show();
			},
			error : function() {
				$("#c2").hide();
			}
		});

	});

});
