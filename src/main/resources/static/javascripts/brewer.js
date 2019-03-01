$(function(){
	var money = $('.js-money');
	money.maskMoney();
	
	var number = $('.js-number');
	number.maskMoney({ precision: 0 })
})