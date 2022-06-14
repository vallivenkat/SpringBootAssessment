const todoControl = new ToDoController();


//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product


newItemForm.addEventListener('submit', (event) => {
    // Prevent default action donot need the form to submit first (1) form validation
    //(2) We are using our own fetch method to send the data over to the backend(Rest API)
    event.preventDefault();
    // Select the inputs
    const newItemTitle = document.querySelector('#newItemTitle');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemTargetDate = document.querySelector('#newItemTargetDate');
    
    // Get the values of the inputs - variable names to be same as MySQL columns
    const Title = newItemTitle.value;
    const Description = newItemDescription.value;
    const TargetDate = newItemTargetDate;

    newItemTitle.value = "";
    newItemDescription.value= "";
    newItemTargetDate.value= "";
    todoControl.addItem(Title,Description,TargetDate);
});
