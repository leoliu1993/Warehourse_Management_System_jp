
// �Զ����У����
$.extend($.fn.validatebox.defaults.rules, {
	midLength : {
		validator : function(value, param) {
			return value.length >= param[0] && value.length <= param[1];
		},
		message : ''
	},
	equalLength : {
		validator : function(value, param) {
			return value.length == param[0];
		},
		message : '�������Ϊ4���ַ�!'
	}
});