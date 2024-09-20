

    function button() {
        document.getElementById("root").style.display = "block";
        document.getElementById("root1").style.display = "block";
        document.getElementById("btn").style.color = "white";
        document.getElementById("btn").style.background = "orange";
        document.getElementById("btn-post").style.color = "orange";
   document.getElementById("btn-post").style.backgroundColor = "white";



        fetch('https://fakestoreapi.com/products/categories')
            .then(response => response.json())
            .then(view => {
                console.log(view)

                document.getElementById("root1").innerHTML = ` categories - ${view}`;

            })


        fetch('http://localhost:8080/api/products')
            .then(response => response.json())
            .then(data => {
                console.log(data);
                // document.getElementById("root").innerHTML = `Search results  - <span id="sp" >${data.length}  </span>`;


                

                fetch('http://localhost:8080/api/products/image/1')
                .then(response => response)
                .then(response => {
                    console.log(response.url);  });


                let data1 = "";

                data.map((product) => {
                    document.getElementById("Products-sec").innerHTML = data1;      

                    data1 +=  ` 
                    <div id="Products-div" > 
                
                <p class="category">${product.name}</p>
                
                <img class="images" src= "http://localhost:8080/api/products/image/${product.id}" alt="">
                <p class="titles">${product.name}</p>
                <b class="price">$${product.price}</b>
                
                <p class="rating"> Rating - ${product.rating.rate} </p>
                <p class="rating"> Count - ${product.rating.count} </p>
                
                  </div> 
                   `;
                 
                   
                });
                
            })
            .catch((err) => { console.log(err); })


         

            
    }

  
    
//     function AddtoCarts(){   
//        let main = document.getElementById("Products-div").innerHTML;
//        console.log(main);
//        let car =  document.getElementById("numbers").innerHTML ;


//        document.getElementById("carts").innerHTML = `carts - ${car} `




// console.log(car);


//         document.getElementById("add-to-carts").style.color = "red";
//            }  


// function AddtoCarts(){

    // fetch('https://fakestoreapi.com/products/3',{
    //     method:"PUT",
    //     body:JSON.stringify(
    //         {
    //             title: 'test product',
    //             price: 13.5,
    //             description: 'lorem ipsum set',
    //             image: 'https://i.pravatar.cc',
    //             category: 'electronic'
    //         }
    //     )
    // })
    //     .then(res=>res.json())
    //     .then(data=> { console.log(data)

    //         button();
    // document.getElementById("carts").innerHTML = `carts-${product.id}`  })
       










//     document.getElementById("add-to-carts").style.color = "red";



// }


// function mycarts(){
//     document.getElementById("cartsdiv").style.display = "block";
// }





function btnpost() {


 fetch('https://fakestoreapi.com/products',{
    method:"POST",
    body:JSON.stringify(
        {
            
            title: "test product Chaithanya",
            price: "000",
            description: "lorem ipsum set",
            image: "https://i.pravatar.cc",
            category: "Humans"
        }
            
    ),

    headers: {
        "Content-type": "application/json; charset=UTF-8"
    }
})



    .then(res=>res.json())
    .then(data => {  console.log(data)
     
      document.getElementById("Products-sec").innerHTML += 
      
         ` <div id="Products-div2" > 
         <p id="numbers">${data.id}</p> 
         <p class="category">${data.category}</p>
         <img class="images" src= ${data.image} alt="">
         <p class="titles">${data.title}</p>
         <b class="price">$${data.price}</b>
         
           </div>   `;





    })



   .catch((err) => { console.log(err); })

   document.getElementById("btn-post").style.color = "white";
   document.getElementById("btn-post").style.backgroundColor = "orange";
   
   


}


