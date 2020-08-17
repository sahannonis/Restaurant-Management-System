if (document.readyState =='loading')
{
    document.addEventListener('DOMContentLoaded', ready)
}
else{
    ready()
}

function ready()
{
    var removeCartItem =document.getElementsByClassName('btn-danger')
    console.log(removeCartItem)
    for(var i=0; i<removeCartItem.length;i++)
    {
        var button = removeCartItem[i]
        button.addEventListener('click', removeCartItem)
       
    }
    var quantityInputs = document.getElementsByClassName('cart-quantity-input')
    for(var i=0; i<quantityInputs.length;i++)
    {
        var input = quantityInputs[i]
        input.addEventListener('change',quantityChanged)
    }
    var addToCart = document.getElementsByClassName('shop-item-button')
    for(var i=0; i<addToCart.length;i++)
    {
        var button= addToCart[i]
        button.addEventListener('click',addToCartClicked)
    }
    document.getElementsByClassName('btn-warning')[0].addEventListener('click',purchaseClicked)
}

function purchaseClicked(event)
{
    alert('Thankyou for your purchase')
    var cartItems= document.getElementsByClassName('cart-items')[0]
    while(cartItems.hasChildNodes())
    {
        cartItems.removeChild(cartItems.firstChild)
    }
    
}

function removeCartItem(event)
{
    var buttonClicked =event.target  
    buttonClicked.parentElement.parentElement.remove()
    updateCartTotal()

}

function quantityChanged(event)
{
    var input = event.target
    if(isNaN(input.value) || input.value <=0)
    {
        input.value =1
    }
    updateCartTotal()
}



function updateCartTotal() 
{
    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    var cartRows = cartItemContainer.getElementsByClassName('cart-row')
    var total =0
    for(var i=0; i<cartRows.length;i++)
    {
        var cartRow = cartRows[i]
        var priceElement =cartRow.getElementsByClassName('cart-price')[0]
        var quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0]
        var price = parseFloat(priceElement.innerText.replace('$',''))
        var quantity = quantityElement.value
        
        total = total + (price *quantity)
    }
    total = Math.round(total *100)/100
    document.getElementsByClassName('cart-total-price')[0].innerText = 'RS.' +total
}

function addToCartClicked(event)
{
    var button = event.target
    var shopItem = button.parentElement.parentElement
    var title = shopItem.getElementsByClassName('shop-item-title')[0].innerText
    //var price = shopItem.getElementsByClassName('shop-item-price')[0].innerText
    var str = shopItem.getElementsByClassName('shop-item-price')[0].innerText
    var price = parseInt(str.substring(6, 10))
    //var imagesrc =  shopItem.getElementsByClassName('shop-item-image')[0].src
    console.log(title, price)
    addItemtoCart(title, price)
    updateCartTotal()
}

function addItemtoCart(title, price)
{
    var cartRow = document.createElement('div')
    cartRow.classList.add('cart-row')
    var cartItems = document.getElementsByClassName('cart-items')[0]
    var cartItemNames = cartItems.getElementsByClassName('cart-item-title')
    for(var i=0; i< cartItemNames.length; i++)
    {
        if(cartItemNames[i].innerText == title)
        {
            alert('This item is already added to the cart')
            return
        }
    }
    var cartRowContents = 
    `
    <div class="cart-item cart-column">
	    
		<span class="cart-item-title">${title}</span>
	</div>
	<span class="cart-price cart-column">${price}</span>
	<div class="cart-quantity cart-column">
		<input class="cart-quantity-input" type="number" value="1">
		<button class="btn btn-danger" type="button">Remove</button>
	</div>
    `
    cartRow.innerHTML = cartRowContents
    cartItems.append(cartRow)
    cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', removeCartItem)
    cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change',quantityChanged)
}

var database = firebase.database();
var storage = firebase.storage();

function add()
{
    var code = Math.floor((Math.random() * 100000) + 1)

    var currentDate = new Date();
    var date = currentDate.getDate();
    var month = currentDate.getMonth(); 
    var year = currentDate.getFullYear();

    var dateString = date + "-" +(month + 1) + "-" + year;

    var unique={
        Date: dateString,
        Code: code
    }
    var selector = document.getElementById('choose');
    var value = selector[selector.selectedIndex].value;

    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    var cartRows = cartItemContainer.getElementsByClassName('cart-row')
    var name=[]
    var quantity=[]
    var data=[]
    var ref = database.ref('Order/'+ value+'/');
    var ref2 = database.ref('Order/'+ value+'/');

    for(i=0; i<cartRows.length ; i++)
    {
        
        var cartRow= cartRows[i]
        name[i]= cartRow.getElementsByClassName('cart-item-title')[0].innerText
        quantity[i] = cartRow.getElementsByClassName('cart-quantity-input')[0].value

        data[i]={
           Name: name[i],
           Quantity: quantity[i]
        }
        console.log(data[i])
        ref.push(data[i]);
       
    }
    console.log(unique)
    ref2.push(unique);

    

    
}