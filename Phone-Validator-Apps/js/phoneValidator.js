$(document).ready(function () {
  $('#customers').kendoGrid({
    dataSource: {
      transport :{
          read:{
              contentType: "application/json",
              type: "GET",
              url: "http://localhost:8080/validator/customers",

          }
      },
     
      // default grouping by country column
      group: { field: "country"},

      schema: {
        model: {
          fields: {
            customerName: { type: 'string'},
            phoneNumber: { type: 'string' },
            country: { type: 'string' },
            countryCode: { type: 'string' },
            phoneValidationState: { type: 'string' },
          },
        },
      },
      pageSize: 10,
    },
    height: 400,
    scrollable: true,
    sortable: true,
    filterable: true,
    groupable: true,
    pageable: {
      input: true,
      numeric: false,
    },
    columns: [
      { field: 'customerName', title: 'Customer Name', width: '130px' },
      { field: 'phoneNumber', title: 'Phone Number', width: '130px' },
      { field: 'countryCode', title: 'Country Code', width: '130px' },
      { field: 'country', title: 'Country', width: '130px' ,  groupHeaderTemplate: (dataItem)=>{
          return `<strong> ${(dataItem.value)? dataItem.value+" count:" : "No Countries found count"} ${dataItem.items.length}</strong>`
      }

      } ,
      {
        field: 'phoneValidationState',
        title: 'Phone Number State',
        width: '130px',
        template: function (dataItem) {
          const phoneState = kendo.htmlEncode(dataItem.phoneValidationState).toLowerCase();
          return `<strong class= "${(phoneState == "valid")? "green" : (phoneState == "invalid")?"red" : "--"}" > ${phoneState.charAt(0).toUpperCase() + phoneState.slice(1)}  </strong>`;
        },
      },
    ],
  });
});
