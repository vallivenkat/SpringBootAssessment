class ToDoController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the database
    addItem(Title, Description,TargetDate)
    {
        
        const formData = new FormData();
        formData.append('Title',Title);
        formData.append('Description', Description);

        formData.append('TargetDate', TargetDate);
        

       fetch('http://localhost:8080/item/add', {
             method: 'POST',
             body: formData
             })
             .then(function(response) {
                 console.log(response.status); // Will show you the status
                 if (response.ok) {
                     alert("Successfully Added ToDo Item!");
                 }
                 else {
                    throw Error(response.statusText);
                 }
             })
             .catch((error) => {
                 console.error('Error:', error);
                 alert("Error adding item to ToDoList")
             });
    }

    //This method will do the fetch method to fetch data from database using
    //the REST API endpoint from Spring Boot
    displayItem()
    {
         let ToDoController = this;
         ToDoController._items = [];

         fetch('http://127.0.0.1:8080/item/all')       
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);
                data.forEach(function (item, index) {

                    const itemObj = {
                        id: item.id,            
                        name: item.Title,        
                        Description: item.Description, 
                        TargetDate:item.TargetDate 
                        
                   };
                    ToDoController._items.push(itemObj);
              });

              ToDoController.renderProductPage();

            })
            .catch(function(error) {
                console.log(error);
            });

    }

    //Based on the item fetched from the displayItem() method and show the products in the
    //product page
    renderProductPage()
    {
        //let ToDoListHTML = [];

        for (let i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

               // const ToDoItem = createHTMLList(i, item.Title, item.Description, item.TargetDate);

                //ToDoListHTML.push(ToDoItem);
        
                    displayTableRow(item.Title, item.Description, item.TargetDate);
                }
            }
        }// End of Class
        
        function displayTableRow(Title, Description, TargetDate ){
          const table = document.querySelector("#displayTable")
        }

            //  insert to first row
//          let cell1 =  newRow.insertCell(0);
//            let cell2 =  newRow.insertCell(1);
//            let cell3 =  newRow.insertCell(2);
        
//            cell1.innerHTML = Title;
//            cell2.innerHTML = Description;
//            cell3.innerHTML = TargetDate;


