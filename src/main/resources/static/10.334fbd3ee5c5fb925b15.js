(self.webpackChunksae_web=self.webpackChunksae_web||[]).push([[10],{7010:(t,e,r)=>{"use strict";r.r(e),r.d(e,{EmpleadosModule:()=>Yt});var o=r(8583),a=r(4655),i=r(3679),n=r(2238),s=r(7716),l=r(5618),c=r(1095);let d=(()=>{class t{constructor(){}ngOnInit(){}}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-success-dialog"]],decls:9,vars:1,consts:[["fxLayout","column","fxLayoutAlign","center center"],["mat-dialog-title",""],["mat-raised-button","","color","primary",3,"mat-dialog-close"]],template:function(t,e){1&t&&(s.TgZ(0,"section",0),s.TgZ(1,"h1",1),s._uU(2,"Success message"),s.qZA(),s.TgZ(3,"mat-dialog-content"),s.TgZ(4,"p"),s._uU(5,"Action completed successfully"),s.qZA(),s.qZA(),s.TgZ(6,"mat-dialog-actions"),s.TgZ(7,"button",2),s._uU(8," OK "),s.qZA(),s.qZA(),s.qZA()),2&t&&(s.xp6(7),s.Q6J("mat-dialog-close",!0))},directives:[l.xw,l.Wh,n.uh,n.xY,n.H8,c.lW,n.ZT],styles:[""]}),t})();var u=(()=>(function(t){t.MASCULICNO="Masculino",t.FEMENICO="Femenino",t.OTRO="Otro"}(u||(u={})),u))(),m=(()=>(function(t){t.SOLTERO="Soltero",t.CASADO="Casado",t.DIVORCIADO="Divorciado",t.VIUDO="Viudo",t.CONCUBINATO="Concubinato",t.OTRO="Otro"}(m||(m={})),m))(),p=(()=>(function(t){t.ACTIVO="Activo",t.BAJA="Baja",t.OTRO="Otro"}(p||(p={})),p))();class g{constructor(){}}var h=r(9761),f=r(8002),Z=r(3342),A=r(1841),x=r(205),q=r(4945),T=r(5304),C=r(2340);let U=(()=>{class t{constructor(t){this.httpClient=t,this.apiUrl=C.N.baseUrl+"/api/ubicacion",this.headers=(new A.WM).set("Content-Type","application/json").set("Accept","application/json"),this.httpOptions={headers:this.headers}}getList(){return this.httpClient.get(this.apiUrl+"/localidad/list",this.httpOptions).pipe((0,q.X)(1),(0,T.K)(this.handleError))}handleError(t){let e="";return e=t.error instanceof ErrorEvent?`Error: ${t.error.message}`:`Error Code: ${t.status}\nMessage: ${t.message}`,window.alert(e),(0,x._)(e)}}return t.\u0275fac=function(e){return new(e||t)(s.LFG(A.eN))},t.\u0275prov=s.Yz7({token:t,factory:t.\u0275fac,providedIn:"root"}),t})();var _=r(3738),N=r(1769),w=r(8295),b=r(9983),y=r(1554),v=r(2458);function I(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Name is required"),s.qZA())}function O(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"No mas de 20 caracteres"),s.qZA())}function E(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Name is required"),s.qZA())}function k(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"No mas de 5 caracteres"),s.qZA())}function S(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"No mas de 20 caracteres"),s.qZA())}function M(t,e){if(1&t&&(s.TgZ(0,"mat-option",17),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.Q6J("value",t),s.xp6(1),s.lnq(" ",t.nombre," (",t.codigoPostal,") ",t.provincia.nombre," ")}}function Y(t,e){if(1&t){const t=s.EpF();s.TgZ(0,"mat-card",2),s.TgZ(1,"mat-card-title"),s._uU(2,"Nueva Direccion"),s.qZA(),s.TgZ(3,"form",3),s.NdJ("ngSubmit",function(){s.CHM(t);const e=s.oxw();return e.create(e.formAddress.value)}),s.TgZ(4,"mat-card-content"),s._UZ(5,"mat-divider"),s.TgZ(6,"div",4),s.TgZ(7,"mat-form-field"),s._UZ(8,"input",5),s.TgZ(9,"mat-hint",6),s._uU(10,"No mas de 20 caracteres"),s.qZA(),s.YNc(11,I,2,0,"mat-error",7),s.YNc(12,O,2,0,"mat-error",7),s.qZA(),s.TgZ(13,"mat-form-field",8),s._UZ(14,"input",9),s.TgZ(15,"mat-hint",6),s._uU(16,"No mas de 5 caracteres."),s.qZA(),s.YNc(17,E,2,0,"mat-error",7),s.YNc(18,k,2,0,"mat-error",7),s.qZA(),s.TgZ(19,"mat-form-field"),s._UZ(20,"input",10),s.YNc(21,S,2,0,"mat-error",7),s.qZA(),s.TgZ(22,"mat-form-field"),s._UZ(23,"input",11),s.TgZ(24,"mat-autocomplete",12,13),s.YNc(26,M,2,4,"mat-option",14),s.ALo(27,"async"),s.qZA(),s.qZA(),s.qZA(),s.qZA(),s.TgZ(28,"mat-card-actions"),s._UZ(29,"mat-divider"),s.TgZ(30,"button",15),s._uU(31," Crear "),s.qZA(),s.TgZ(32,"button",16),s.NdJ("click",function(){return s.CHM(t),s.oxw().onNoClick()}),s._uU(33," Cancelar "),s.qZA(),s.qZA(),s.qZA(),s.qZA()}if(2&t){const t=s.MAs(25),e=s.oxw();s.xp6(3),s.Q6J("formGroup",e.formAddress),s.xp6(8),s.Q6J("ngIf",e.hasError("street","required")),s.xp6(1),s.Q6J("ngIf",e.hasError("street","maxlength")),s.xp6(5),s.Q6J("ngIf",e.hasError("number","required")),s.xp6(1),s.Q6J("ngIf",e.hasError("number","maxlength")),s.xp6(3),s.Q6J("ngIf",e.hasError("number","maxlength")),s.xp6(2),s.Q6J("formControl",e.myControl)("matAutocomplete",t),s.xp6(1),s.Q6J("displayWith",e.displayFn),s.xp6(2),s.Q6J("ngForOf",s.lcZ(27,11,e.filteredOptions)),s.xp6(4),s.Q6J("disabled",!e.formAddress.valid)}}let D=(()=>{class t{constructor(t,e,r,o){this.dialogRef=t,this.data=e,this.localidadSvc=r,this.formBuilder=o,this.myControl=new i.NI("",[i.kI.required]),this.options=[],this.isDataAvailable=!1,this.direccion=e}ngOnInit(){this.loadCitys(),console.log("ngOnInit",this.direccion.localidad),this.formAddress=this.formBuilder.group({street:new i.NI(this.direccion.calle,[i.kI.required,i.kI.maxLength(20)]),number:new i.NI(this.direccion.numero,[i.kI.required,i.kI.maxLength(5)]),info:new i.NI(this.direccion.info?this.direccion.info:"",[i.kI.maxLength(20)]),city:this.myControl}),this.myControl.setValue(this.direccion.localidad?this.direccion.localidad:""),this.filteredOptions=this.myControl.valueChanges.pipe((0,h.O)(""),(0,f.U)(t=>"string"==typeof t?t:t.nombre),(0,f.U)(t=>t?this._filter(t):this.options.slice())),this.displayFn(this.direccion.localidad)}displayFn(t){return t?t.nombre:""}_filter(t){const e=t.toLowerCase();return this.options.filter(t=>t.nombre.toLowerCase().includes(e))}create(t){this.formAddress.valid&&this.executeCreation(t)}executeCreation(t){this.direccion.calle=t.street,this.direccion.numero=t.number,this.direccion.info=t.info,this.direccion.localidad=t.city,this.dialogRef.close(this.direccion)}hasError(t,e){return this.formAddress.controls[t].hasError(e)}loadCitys(){this.localidadSvc.getList().pipe((0,Z.b)(t=>this.options=t)).subscribe(),this.isDataAvailable=!0}onNoClick(){this.dialogRef.close()}}return t.\u0275fac=function(e){return new(e||t)(s.Y36(n.so),s.Y36(n.WI),s.Y36(U),s.Y36(i.qu))},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-direccion-dialog"]],decls:2,vars:1,consts:[["fxLayout","row wrap","fxLayoutAlign","center center"],["fxFlex","90%","fxFlex.xs","100%","class","formDireccion",4,"ngIf"],["fxFlex","90%","fxFlex.xs","100%",1,"formDireccion"],["autocomplete","off","novalidate","","fxLayout","column wrap","fxLayoutAlign","center center","fxLayoutGap","10px",3,"formGroup","ngSubmit"],[1,"items"],["matInput","","type","text","placeholder","Calle","formControlName","street","id","street"],["align","end"],[4,"ngIf"],[1,"input-number"],["matInput","","type","text","placeholder","Numero","formControlName","number","id","number"],["matInput","","type","text","placeholder","Info: Piso 1 / Dpto B","formControlName","info","id","info"],["matInput","","type","text","placeholder","Localidad","aria-label","Localidad","required","",3,"formControl","matAutocomplete"],["autoActiveFirstOption","",3,"displayWith"],["auto","matAutocomplete"],[3,"value",4,"ngFor","ngForOf"],["mat-raised-button","","md-dialog-close","","color","primary","type","submit",3,"disabled"],["type","button","mat-raised-button","","md-dialog-close","","color","warn",3,"click"],[3,"value"]],template:function(t,e){1&t&&(s.TgZ(0,"section",0),s.YNc(1,Y,34,13,"mat-card",1),s.qZA()),2&t&&(s.xp6(1),s.Q6J("ngIf",e.isDataAvailable))},directives:[o.O5,_.a8,_.n5,i._Y,i.JL,i.sg,_.dn,N.d,w.KE,b.Nt,i.Fj,i.JJ,i.u,w.bx,y.ZL,i.Q7,i.oH,y.XC,o.sg,_.hq,c.lW,w.TO,v.ey],pipes:[o.Ov],styles:[".formDireccion[_ngcontent-%COMP%]{min-width:350px;margin-top:5px}.formDireccion[_ngcontent-%COMP%]   .items[_ngcontent-%COMP%]{display:flex;flex-flow:row wrap;justify-content:space-around}.formDireccion[_ngcontent-%COMP%]   mat-form-field[_ngcontent-%COMP%]{margin:auto;padding:10px;width:300px;min-width:200px}.formDireccion[_ngcontent-%COMP%]   .input-number[_ngcontent-%COMP%]{width:120px;min-width:80px}mat-card-title[_ngcontent-%COMP%]{text-align:center}"]}),t})();class J{constructor(){}}class L{}let Q=(()=>{class t{constructor(t){this.httpClient=t,this.apiUrl=C.N.baseUrl+"/api/empleado",this.headers=(new A.WM).set("Content-Type","application/json").set("Accept","application/json"),this.httpOptions={headers:this.headers}}getList(){return this.httpClient.get(this.apiUrl+"/list",this.httpOptions).pipe((0,q.X)(1),(0,T.K)(this.handleError))}get(t){return this.httpClient.get(`${this.apiUrl}/${t}`,this.httpOptions).pipe((0,f.U)(t=>t||{}),(0,T.K)(this.handleError))}create(t){return this.httpClient.post(this.apiUrl+"/create",this.dataToEmpleado(t),this.httpOptions)}dataToEmpleado(t){let e=[];if(null!=t.cellPhone){let r=new L;r.idContacto=-1,r.nombre="Personal",r.tipo="CELULAR",r.dato=t.cellPhone,r.info="",e.push(r)}if(null!=t.cellPhone){let r=new L;r.idContacto=-1,r.nombre="Personal",r.tipo="EMAIL",r.dato=t.email,r.info="",e.push(r)}let r=new J;return r.idPersona=-1,r.nombre=t.firstName,r.apellido=t.lastName,r.nacimiento=t.dateOfBirth,r.dni=t.dni,r.cuil="",r.domicilio=t.address,r.contactoList=e,r.categoria=t.category,r.puesto=t.position,r.genero=t.gender,r.estado=p.ACTIVO,r.estadoCivil=t.maritalStatus,r.info=t.info,r.fechaAlta=t.dateStart,r.fechaBaja=new Date,console.log(JSON.stringify({data:r},null,4)),r}update(t,e){return this.httpClient.put(`${this.apiUrl}/update/${t}`,e)}delete(t){return this.httpClient.delete(`${this.apiUrl}/${t}`)}handleError(t){let e="";return e=t.error instanceof ErrorEvent?`Error: ${t.error.message}`:`Error Code: ${t.status}\nMessage: ${t.message}`,window.alert(e),(0,x._)(e)}}return t.\u0275fac=function(e){return new(e||t)(s.LFG(A.eN))},t.\u0275prov=s.Yz7({token:t,factory:t.\u0275fac,providedIn:"root"}),t})(),P=(()=>{class t{constructor(t){this.http=t,this.apiUrl=C.N.baseUrl+"/api/empleado-categoria"}getAll(){return this.http.get(this.apiUrl+"/list").pipe((0,q.X)(1),(0,T.K)(this.handleError))}get(t){return this.http.get(`${this.apiUrl}/${t}`)}create(t){return this.http.post(this.apiUrl,t)}update(t,e){return this.http.put(`${this.apiUrl}/update/${t}`,e)}delete(t){return this.http.delete(`${this.apiUrl}/${t}`)}handleError(t){let e="";return e=t.error instanceof ErrorEvent?`Error: ${t.error.message}`:`Error Code: ${t.status}\nMessage: ${t.message}`,window.alert(e),(0,x._)(e)}}return t.\u0275fac=function(e){return new(e||t)(s.LFG(A.eN))},t.\u0275prov=s.Yz7({token:t,factory:t.\u0275fac,providedIn:"root"}),t})(),F=(()=>{class t{constructor(t){this.http=t,this.apiUrl=C.N.baseUrl+"/api/empleado-puesto"}getAll(){return this.http.get(this.apiUrl+"/list").pipe((0,q.X)(1),(0,T.K)(this.handleError))}get(t){return this.http.get(`${this.apiUrl}/${t}`)}create(t){return this.http.post(this.apiUrl,t)}update(t,e){return this.http.put(`${this.apiUrl}/update/${t}`,e)}delete(t){return this.http.delete(`${this.apiUrl}/${t}`)}handleError(t){let e="";return e=t.error instanceof ErrorEvent?`Error: ${t.error.message}`:`Error Code: ${t.status}\nMessage: ${t.message}`,window.alert(e),(0,x._)(e)}}return t.\u0275fac=function(e){return new(e||t)(s.LFG(A.eN))},t.\u0275prov=s.Yz7({token:t,factory:t.\u0275fac,providedIn:"root"}),t})(),$=(()=>{class t{constructor(t,e){this.dialogRef=t,this.data=e}ngOnInit(){}closeDialog(){this.dialogRef.close()}}return t.\u0275fac=function(e){return new(e||t)(s.Y36(n.so),s.Y36(n.WI))},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-error-dialog"]],decls:9,vars:1,consts:[["fxLayout","column","fxLayoutAlign","center center"],["mat-dialog-title",""],["mat-raised-button","","color","warn",3,"click"]],template:function(t,e){1&t&&(s.TgZ(0,"section",0),s.TgZ(1,"h1",1),s._uU(2,"Error message"),s.qZA(),s.TgZ(3,"mat-dialog-content"),s.TgZ(4,"p"),s._uU(5),s.qZA(),s.qZA(),s.TgZ(6,"mat-dialog-actions"),s.TgZ(7,"button",2),s.NdJ("click",function(){return e.closeDialog()}),s._uU(8,"OK"),s.qZA(),s.qZA(),s.qZA()),2&t&&(s.xp6(5),s.Oqu(e.data.errorMessage))},directives:[l.xw,l.Wh,n.uh,n.xY,n.H8,c.lW],styles:[""]}),t})(),B=(()=>{class t{constructor(t,e){this.router=t,this.dialog=e,this.errorMessage="",this.handleError=t=>{500===t.status?this.handle500Error(t):404===t.status?this.handle404Error(t):this.handleOtherError(t)},this.handle500Error=t=>{this.createErrorMessage(t),this.router.navigate(["/500"])},this.handle404Error=t=>{this.createErrorMessage(t),this.router.navigate(["/404"])},this.handleOtherError=t=>{this.createErrorMessage(t),this.dialogConfig.data={errorMessage:this.errorMessage},this.dialog.open($,this.dialogConfig)}}createErrorMessage(t){this.errorMessage=t.error?t.error:t.statusText,console.log("createErrorMessage:::",this.errorMessage)}}return t.\u0275fac=function(e){return new(e||t)(s.LFG(a.F0),s.LFG(n.uw))},t.\u0275prov=s.Yz7({token:t,factory:t.\u0275fac,providedIn:"root"}),t})();var j=r(3220),R=r(7441),G=r(628),H=r(6627);function W(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Name is required"),s.qZA())}function z(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"No mas de 20 caracteres"),s.qZA())}function X(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Name is required"),s.qZA())}function K(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"No mas de 20 caracteres"),s.qZA())}function V(t,e){if(1&t&&(s.TgZ(0,"mat-option",29),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.Q6J("value",t),s.xp6(1),s.hij(" ",t," ")}}function tt(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Seleccionar uno."),s.qZA())}function et(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Address is required"),s.qZA())}function rt(t,e){if(1&t&&(s.TgZ(0,"mat-option",29),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.Q6J("value",t),s.xp6(1),s.hij(" ",t," ")}}function ot(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Seleccionar uno."),s.qZA())}function at(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"email incorrecto."),s.qZA())}function it(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Error"),s.qZA())}function nt(t,e){if(1&t&&(s.TgZ(0,"mat-option",29),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.Q6J("value",t),s.xp6(1),s.AsE(" ",t.nombre," ( ",t.info," ) ")}}function st(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Seleccionar uno."),s.qZA())}function lt(t,e){if(1&t&&(s.TgZ(0,"mat-option",29),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.Q6J("value",t),s.xp6(1),s.AsE(" ",t.nombre," ( ",t.info," ) ")}}function ct(t,e){1&t&&(s.TgZ(0,"mat-error"),s._uU(1,"Seleccionar uno."),s.qZA())}let dt=(()=>{class t{constructor(t,e,r,o,a,i){this.location=t,this.empleadoSvc=e,this.categoriaSvc=r,this.puestoSvc=o,this.dialog=a,this.errorSvc=i,this.genders=Object.values(u),this.maritalStatuss=Object.values(m)}ngOnInit(){this.loadCategorys(),this.loadPositions(),this.address=new g,this.addresShow="Editar direccion",this.empleado=new i.cw({firstName:new i.NI("",[i.kI.required,i.kI.maxLength(20)]),lastName:new i.NI("",[i.kI.required,i.kI.maxLength(20)]),dateOfBirth:new i.NI(new Date),gender:new i.NI("",[i.kI.required]),dni:new i.NI("",[i.kI.required,i.kI.maxLength(8)]),maritalStatus:new i.NI("",[i.kI.required]),dateStart:new i.NI(new Date),cuil:new i.NI("",[i.kI.maxLength(13)]),category:new i.NI("",[i.kI.required]),position:new i.NI("",[i.kI.required]),address:new i.NI(""),cellPhone:new i.NI("",[i.kI.maxLength(10),i.kI.maxLength(10)]),email:new i.NI("",[i.kI.email])}),this.dialogConfig={height:"200px",width:"400px",disableClose:!0,data:{}}}hasError(t,e){return this.empleado.controls[t].hasError(e)}onCancel(){this.location.back()}createEmppleado(t){this.empleado.valid&&this.executeCreation(t)}executeCreation(t){this.empleadoSvc.create({firstName:t.firstName,lastName:t.lastName,dateOfBirth:t.dateOfBirth,gender:t.gender,dni:t.dni,maritalStatus:t.maritalStatus,address:this.address,dateStart:t.dateStart,cuil:t.cuil,category:t.category,position:t.position,info:t.info,cellPhone:t.cellPhone,email:t.email}).subscribe(t=>{this.dialog.open(d,this.dialogConfig).afterClosed().subscribe(t=>{this.location.back()})},t=>{this.errorSvc.dialogConfig=Object.assign({},this.dialogConfig),this.errorSvc.handleError(t)})}openDireccionDialog(){const t=new n.vA;t.disableClose=!0,t.autoFocus=!0,t.data=this.address,this.dialog.open(D,t).afterClosed().subscribe(t=>{null!=t&&this.setAddress(t)})}setAddress(t){this.address=t,this.addresShow=t.calle+" "+t.numero+" - "+t.localidad.nombre}loadPositions(){this.puestoSvc.getAll().pipe().subscribe(t=>this.positions=t)}loadCategorys(){this.categoriaSvc.getAll().pipe().subscribe(t=>this.categorys=t)}ngOnDestroy(){console.log("CHAUUU::::::")}}return t.\u0275fac=function(e){return new(e||t)(s.Y36(o.Ye),s.Y36(Q),s.Y36(P),s.Y36(F),s.Y36(n.uw),s.Y36(B))},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-empleado-create"]],decls:110,vars:22,consts:[["fxLayout","row wrap","fxLayoutAlign","center center"],["fxFlex","90%","fxFlex.xs","100%",1,"formEmpleado"],["autocomplete","off","novalidate","","fxLayout","column wrap","fxLayoutAlign","center center","fxLayoutGap","10px",3,"formGroup","ngSubmit"],[1,"items"],["matInput","","type","text","placeholder","Nombre/s","formControlName","firstName","id","firstName"],["align","end"],[4,"ngIf"],["matInput","","type","text","placeholder","Apellido/s","formControlName","lastName","id","lastName"],[1,"input-small"],["matInput","","placeholder","Fecha Nacimiento","formControlName","dateOfBirth","id","dateOfBirth","readonly","",3,"matDatepicker","click"],["matSuffix","",3,"for"],["picker",""],["formControlName","gender","id","gender","required",""],[3,"value",4,"ngFor","ngForOf"],["matInput","","mask","00.000.000","placeholder","D.N.I","formControlName","dni"],["formControlName","maritalStatus","id","maritalStatus","required",""],["matInput","","disabled","",3,"value"],["mat-button","","matSuffix","","mat-stroked-button","","aria-label","search",3,"click"],["matInput","","mask","0000-000 000","placeholder","Numero Celular","formControlName","cellPhone"],["matSuffix",""],["type","email","matInput","","placeholder","pat@example.com","formControlName","email"],["matInput","","placeholder","Fecha de Alta","formControlName","dateStart","id","dateStart","readonly","",3,"matDatepicker","click"],["picker2",""],["matInput","","mask","00-00000000-0","placeholder","C.U.I.L","formControlName","cuil","id","cuil"],["formControlName","category","id","category","required",""],["formControlName","position","id","position","required",""],["matInput","","type","text","placeholder","Info","id","info"],["mat-raised-button","","color","primary",3,"disabled"],["type","button","mat-raised-button","","color","warn",3,"click"],[3,"value"]],template:function(t,e){if(1&t){const t=s.EpF();s.TgZ(0,"section",0),s.TgZ(1,"mat-card",1),s.TgZ(2,"mat-card-title"),s._uU(3,"Nuevo Empleado"),s.qZA(),s.TgZ(4,"form",2),s.NdJ("ngSubmit",function(){return e.createEmppleado(e.empleado.value)}),s.TgZ(5,"mat-card-content"),s._UZ(6,"mat-divider"),s.TgZ(7,"h2"),s._uU(8,"Datos Personales"),s.qZA(),s.TgZ(9,"div",3),s.TgZ(10,"mat-form-field"),s._UZ(11,"input",4),s.TgZ(12,"mat-hint",5),s._uU(13,"No mas de 20 caracteres"),s.qZA(),s.YNc(14,W,2,0,"mat-error",6),s.YNc(15,z,2,0,"mat-error",6),s.qZA(),s.TgZ(16,"mat-form-field"),s._UZ(17,"input",7),s.TgZ(18,"mat-hint",5),s._uU(19,"No mas de 20 caracteres."),s.qZA(),s.YNc(20,X,2,0,"mat-error",6),s.YNc(21,K,2,0,"mat-error",6),s.qZA(),s.TgZ(22,"mat-form-field",8),s.TgZ(23,"input",9),s.NdJ("click",function(){return s.CHM(t),s.MAs(26).open()}),s.qZA(),s._UZ(24,"mat-datepicker-toggle",10),s._UZ(25,"mat-datepicker",null,11),s.qZA(),s.TgZ(27,"mat-form-field",8),s.TgZ(28,"mat-label"),s._uU(29,"Genero"),s.qZA(),s.TgZ(30,"mat-select",12),s.TgZ(31,"mat-option"),s._uU(32,"--"),s.qZA(),s.YNc(33,V,2,2,"mat-option",13),s.qZA(),s.YNc(34,tt,2,0,"mat-error",6),s.qZA(),s.TgZ(35,"mat-form-field",8),s._UZ(36,"input",14),s.TgZ(37,"mat-hint",5),s._uU(38,"Sin puntos."),s.qZA(),s.YNc(39,et,2,0,"mat-error",6),s.qZA(),s.TgZ(40,"mat-form-field",8),s.TgZ(41,"mat-label"),s._uU(42,"Estado Civil"),s.qZA(),s.TgZ(43,"mat-select",15),s.TgZ(44,"mat-option"),s._uU(45,"--"),s.qZA(),s.YNc(46,rt,2,2,"mat-option",13),s.qZA(),s.YNc(47,ot,2,0,"mat-error",6),s.qZA(),s.qZA(),s._UZ(48,"mat-divider"),s.TgZ(49,"h3"),s._uU(50,"Contacto"),s.qZA(),s.TgZ(51,"div",3),s.TgZ(52,"mat-form-field"),s.TgZ(53,"mat-label"),s._uU(54,"Direccion"),s.qZA(),s._UZ(55,"input",16),s.TgZ(56,"button",17),s.NdJ("click",function(){return e.openDireccionDialog()}),s.TgZ(57,"mat-icon"),s._uU(58,"edit"),s.qZA(),s.qZA(),s.qZA(),s.TgZ(59,"mat-form-field"),s.TgZ(60,"mat-label"),s._uU(61,"Celular"),s.qZA(),s._UZ(62,"input",18),s.TgZ(63,"mat-icon",19),s._uU(64,"phone"),s.qZA(),s.TgZ(65,"mat-hint"),s._uU(66,"1234-123456"),s.qZA(),s.qZA(),s.TgZ(67,"mat-form-field"),s.TgZ(68,"mat-label"),s._uU(69,"email"),s.qZA(),s._UZ(70,"input",20),s.YNc(71,at,2,0,"mat-error",6),s.qZA(),s.qZA(),s._UZ(72,"mat-divider"),s.TgZ(73,"h2"),s._uU(74,"Datos Laborales"),s.qZA(),s.TgZ(75,"div",3),s.TgZ(76,"mat-form-field",8),s.TgZ(77,"input",21),s.NdJ("click",function(){return s.CHM(t),s.MAs(26).open()}),s.qZA(),s._UZ(78,"mat-datepicker-toggle",10),s._UZ(79,"mat-datepicker",null,22),s.qZA(),s.TgZ(81,"mat-form-field",8),s._UZ(82,"input",23),s.TgZ(83,"mat-hint",5),s._uU(84,"Sin guiones"),s.qZA(),s.YNc(85,it,2,0,"mat-error",6),s.qZA(),s.TgZ(86,"mat-form-field"),s.TgZ(87,"mat-label"),s._uU(88,"Categoria"),s.qZA(),s.TgZ(89,"mat-select",24),s.TgZ(90,"mat-option"),s._uU(91,"--"),s.qZA(),s.YNc(92,nt,2,3,"mat-option",13),s.qZA(),s.YNc(93,st,2,0,"mat-error",6),s.qZA(),s.TgZ(94,"mat-form-field"),s.TgZ(95,"mat-label"),s._uU(96,"Puesto"),s.qZA(),s.TgZ(97,"mat-select",25),s.TgZ(98,"mat-option"),s._uU(99,"--"),s.qZA(),s.YNc(100,lt,2,3,"mat-option",13),s.qZA(),s.YNc(101,ct,2,0,"mat-error",6),s.qZA(),s.TgZ(102,"mat-form-field"),s._UZ(103,"input",26),s.qZA(),s.qZA(),s.qZA(),s.TgZ(104,"mat-card-actions"),s._UZ(105,"mat-divider"),s.TgZ(106,"button",27),s._uU(107," Create "),s.qZA(),s.TgZ(108,"button",28),s.NdJ("click",function(){return e.onCancel()}),s._uU(109," Cancel "),s.qZA(),s.qZA(),s.qZA(),s.qZA(),s.qZA()}if(2&t){const t=s.MAs(26),r=s.MAs(80);s.xp6(4),s.Q6J("formGroup",e.empleado),s.xp6(10),s.Q6J("ngIf",e.hasError("firstName","required")),s.xp6(1),s.Q6J("ngIf",e.hasError("firstName","maxlength")),s.xp6(5),s.Q6J("ngIf",e.hasError("lastName","required")),s.xp6(1),s.Q6J("ngIf",e.hasError("lastName","maxlength")),s.xp6(2),s.Q6J("matDatepicker",t),s.xp6(1),s.Q6J("for",t),s.xp6(9),s.Q6J("ngForOf",e.genders),s.xp6(1),s.Q6J("ngIf",e.hasError("gender","required")),s.xp6(5),s.Q6J("ngIf",e.hasError("dni","required")),s.xp6(7),s.Q6J("ngForOf",e.maritalStatuss),s.xp6(1),s.Q6J("ngIf",e.hasError("maritalStatus","required")),s.xp6(8),s.s9C("value",e.addresShow),s.xp6(16),s.Q6J("ngIf",e.hasError("email","email")),s.xp6(6),s.Q6J("matDatepicker",r),s.xp6(1),s.Q6J("for",r),s.xp6(7),s.Q6J("ngIf",e.hasError("cuil","maxlength")),s.xp6(7),s.Q6J("ngForOf",e.categorys),s.xp6(1),s.Q6J("ngIf",e.hasError("category","required")),s.xp6(7),s.Q6J("ngForOf",e.positions),s.xp6(1),s.Q6J("ngIf",e.hasError("maritalStatus","required")),s.xp6(5),s.Q6J("disabled",!e.empleado.valid)}},directives:[l.xw,l.Wh,_.a8,l.yH,_.n5,i._Y,i.JL,l.SQ,i.sg,_.dn,N.d,w.KE,b.Nt,i.Fj,i.JJ,i.u,w.bx,o.O5,j.hl,j.nW,w.R9,j.Mq,w.hX,R.gD,i.Q7,v.ey,o.sg,G.hx,c.lW,H.Hw,_.hq,w.TO],styles:[".formEmpleado[_ngcontent-%COMP%]{min-width:350px;margin-top:5px}.formEmpleado[_ngcontent-%COMP%]   .items[_ngcontent-%COMP%]{display:flex;flex-flow:row wrap;justify-content:space-around}.formEmpleado[_ngcontent-%COMP%]   mat-form-field[_ngcontent-%COMP%]{margin:auto;padding:10px;width:250px;min-width:200px}.formEmpleado[_ngcontent-%COMP%]   .input-small[_ngcontent-%COMP%]{width:120px;min-width:100px;padding:0 35px}mat-card-title[_ngcontent-%COMP%]{text-align:center}@media print{button[_ngcontent-%COMP%], footer[_ngcontent-%COMP%], header[_ngcontent-%COMP%]   nav[_ngcontent-%COMP%]{display:none}}"]}),t})(),ut=(()=>{class t{constructor(t,e){this.empleadoSvc=t,this.activeRoute=e}ngOnInit(){this.getDetails()}getDetails(){this.empleadoSvc.get(this.activeRoute.snapshot.params.id).pipe((0,Z.b)(t=>this.empleadoSelect=t)).subscribe()}}return t.\u0275fac=function(e){return new(e||t)(s.Y36(Q),s.Y36(a.gz))},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-empleado-details"]],decls:4,vars:3,template:function(t,e){1&t&&(s.TgZ(0,"p"),s._uU(1,"empleado-details works!"),s.qZA(),s._uU(2),s.ALo(3,"json")),2&t&&(s.xp6(2),s.hij(" ",s.lcZ(3,1,e.empleadoSelect),"\n"))},pipes:[o.Ts],styles:[""]}),t})();var mt=r(9692),pt=r(1494),gt=r(2091);function ht(t,e){1&t&&(s.TgZ(0,"th",19),s._uU(1,"Empleado"),s.qZA())}function ft(t,e){if(1&t&&(s.TgZ(0,"td",20),s._uU(1),s.qZA()),2&t){const t=e.$implicit,r=s.oxw();s.xp6(1),s.hij(" ",r.getFullName(t)," ")}}function Zt(t,e){1&t&&(s.TgZ(0,"th",19),s._uU(1,"DNI"),s.qZA())}function At(t,e){if(1&t&&(s.TgZ(0,"td",21),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.xp6(1),s.hij(" ",t.dni," ")}}function xt(t,e){1&t&&(s.TgZ(0,"th",19),s._uU(1,"Fecha Alta"),s.qZA())}function qt(t,e){if(1&t&&(s.TgZ(0,"td",20),s._uU(1),s.ALo(2,"date"),s.qZA()),2&t){const t=e.$implicit;s.xp6(1),s.hij(" ",s.xi3(2,1,t.fechaAlta,"dd/MM/yyyy")," ")}}function Tt(t,e){1&t&&(s.TgZ(0,"th",19),s._uU(1,"Antiguedad"),s.qZA())}function Ct(t,e){if(1&t&&(s.TgZ(0,"td",20),s._uU(1),s.qZA()),2&t){const t=e.$implicit,r=s.oxw();s.xp6(1),s.hij(" ",r.calcAntiguedad(t.fechaAlta)," ")}}function Ut(t,e){1&t&&(s.TgZ(0,"th",19),s._uU(1,"Puesto"),s.qZA())}function _t(t,e){if(1&t&&(s.TgZ(0,"td",20),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.xp6(1),s.Oqu(t.puesto.nombre)}}function Nt(t,e){1&t&&(s.TgZ(0,"th",19),s._uU(1,"Categoria"),s.qZA())}function wt(t,e){if(1&t&&(s.TgZ(0,"td",20),s._uU(1),s.qZA()),2&t){const t=e.$implicit;s.xp6(1),s.hij(" ",t.categoria.nombre," ")}}function bt(t,e){1&t&&(s.TgZ(0,"th",22),s._uU(1,"Detalle"),s.qZA())}function yt(t,e){if(1&t){const t=s.EpF();s.TgZ(0,"td",20),s.TgZ(1,"button",23),s.NdJ("click",function(){const e=s.CHM(t).$implicit;return s.oxw().redirectToDetails(e.idPersona)}),s.TgZ(2,"mat-icon",24),s._uU(3,"reorder"),s.qZA(),s.qZA(),s.qZA()}}function vt(t,e){1&t&&s._UZ(0,"tr",25)}function It(t,e){1&t&&s._UZ(0,"tr",26)}const Ot=function(){return[10,20,50,100]};let Et=(()=>{class t{constructor(t,e){this.empleadoSvc=t,this.router=e,this.columnas=["apellido","dni","fechaAlta","antiguedad","puesto","categoria","details"],this.dataSource=new gt.by}ngOnInit(){this.loadEmpleados()}ngAfterViewInit(){this.dataSource.sort=this.sort,this.dataSource.paginator=this.paginator}loadEmpleados(){this.empleadoSvc.getList().pipe((0,Z.b)(t=>this.dataSource.data=t)).subscribe()}redirectToDetails(t){let e=`empleados/details/${t}`;console.log("ID::::",e),this.router.navigate([e])}getFullName(t){return t.apellido+" "+t.nombre}calcAntiguedad(t){let e=new Date(t),r=0;try{const t=new Date;r=t.getFullYear()-e.getFullYear();const o=t.getMonth()-e.getMonth();(o<0||0===o&&t.getDate()<e.getDate())&&r--}catch(o){console.error("Log error",o)}return r}applyFilter(t){this.dataSource.filter=t.target.value.trim().toLowerCase()}}return t.\u0275fac=function(e){return new(e||t)(s.Y36(Q),s.Y36(a.F0))},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-empleado-list"]],viewQuery:function(t,e){if(1&t&&(s.Gf(pt.YE,5),s.Gf(mt.NW,5)),2&t){let t;s.iGM(t=s.CRH())&&(e.sort=t.first),s.iGM(t=s.CRH())&&(e.paginator=t.first)}},decls:31,vars:6,consts:[[1,"container"],["appearance","standard"],["matInput","","placeholder","Ex. ium",3,"keyup"],["input",""],["mat-table","","matSort","",1,"mat-elevation-z8",3,"dataSource"],["matColumnDef","apellido"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["matColumnDef","dni"],["mat-cell","","mask","00.000.000",4,"matCellDef"],["matColumnDef","fechaAlta"],["matColumnDef","antiguedad"],["matColumnDef","puesto"],["matColumnDef","categoria"],["matColumnDef","details"],["mat-header-cell","",4,"matHeaderCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["mat-row","","matRipple","",4,"matRowDef","matRowDefColumns"],[3,"pageSize","pageSizeOptions"],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-cell","","mask","00.000.000"],["mat-header-cell",""],["mat-icon-button","","color","primary",3,"click"],[1,"mat-18"],["mat-header-row",""],["mat-row","","matRipple",""]],template:function(t,e){1&t&&(s.TgZ(0,"section",0),s.TgZ(1,"mat-form-field",1),s.TgZ(2,"mat-label"),s._uU(3,"Buscar..."),s.qZA(),s.TgZ(4,"input",2,3),s.NdJ("keyup",function(t){return e.applyFilter(t)}),s.qZA(),s.qZA(),s.TgZ(6,"table",4),s.ynx(7,5),s.YNc(8,ht,2,0,"th",6),s.YNc(9,ft,2,1,"td",7),s.BQk(),s.ynx(10,8),s.YNc(11,Zt,2,0,"th",6),s.YNc(12,At,2,1,"td",9),s.BQk(),s.ynx(13,10),s.YNc(14,xt,2,0,"th",6),s.YNc(15,qt,3,4,"td",7),s.BQk(),s.ynx(16,11),s.YNc(17,Tt,2,0,"th",6),s.YNc(18,Ct,2,1,"td",7),s.BQk(),s.ynx(19,12),s.YNc(20,Ut,2,0,"th",6),s.YNc(21,_t,2,1,"td",7),s.BQk(),s.ynx(22,13),s.YNc(23,Nt,2,0,"th",6),s.YNc(24,wt,2,1,"td",7),s.BQk(),s.ynx(25,14),s.YNc(26,bt,2,0,"th",15),s.YNc(27,yt,4,0,"td",7),s.BQk(),s.YNc(28,vt,1,0,"tr",16),s.YNc(29,It,1,0,"tr",17),s.qZA(),s._UZ(30,"mat-paginator",18),s.qZA()),2&t&&(s.xp6(6),s.Q6J("dataSource",e.dataSource),s.xp6(22),s.Q6J("matHeaderRowDef",e.columnas),s.xp6(1),s.Q6J("matRowDefColumns",e.columnas),s.xp6(1),s.Q6J("pageSize",10)("pageSizeOptions",s.DdM(5,Ot)))},directives:[w.KE,w.hX,b.Nt,gt.BZ,pt.YE,gt.w1,gt.fO,gt.Dz,gt.as,gt.nj,mt.NW,gt.ge,pt.nU,gt.ev,c.lW,H.Hw,gt.XQ,gt.Gk,v.wG],pipes:[o.uU],styles:["table[_ngcontent-%COMP%]{width:100%;overflow-x:auto;overflow-y:hidden;min-width:500px}.mat-form-field[_ngcontent-%COMP%]{font-size:14px;width:100%}tr.mat-row[_ngcontent-%COMP%]:hover{background-color:orange}"]}),t})();const kt=[{path:"",component:(()=>{class t{constructor(){}ngOnInit(){}}return t.\u0275fac=function(e){return new(e||t)},t.\u0275cmp=s.Xpm({type:t,selectors:[["app-empleados"]],decls:10,vars:2,consts:[[1,"example-label"],[1,"example-button-row"],["mat-stroked-button","","color","primary","routerLinkActive","active",3,"routerLink"],["mat-stroked-button","","color","primary","routerLinkActive","",3,"routerLink"]],template:function(t,e){1&t&&(s.TgZ(0,"section"),s.TgZ(1,"div",0),s._uU(2,"Empleados"),s.qZA(),s.TgZ(3,"div",1),s.TgZ(4,"button",2),s._uU(5," Todos "),s.qZA(),s.TgZ(6,"button",3),s._uU(7," Nuevo "),s.qZA(),s.qZA(),s.qZA(),s._UZ(8,"mat-divider"),s._UZ(9,"router-outlet")),2&t&&(s.xp6(4),s.Q6J("routerLink","list"),s.xp6(2),s.Q6J("routerLink","create"))},directives:[c.lW,a.Od,a.rH,N.d,a.lC],styles:["section[_ngcontent-%COMP%]{display:table}.example-label[_ngcontent-%COMP%]{display:table-cell;font-size:16px;margin-left:8px;min-width:120px}.example-button-row[_ngcontent-%COMP%]{display:table-cell;width:490px}.example-button-row[_ngcontent-%COMP%]   .mat-button-base[_ngcontent-%COMP%]{margin:8px 8px 8px 0}"]}),t})(),children:[{path:"list",component:Et},{path:"details/:id",component:ut},{path:"create",component:dt},{path:"",redirectTo:"list",pathMatch:"full"},{path:"**",redirectTo:"list",pathMatch:"full"}]}];let St=(()=>{class t{}return t.\u0275fac=function(e){return new(e||t)},t.\u0275mod=s.oAB({type:t}),t.\u0275inj=s.cJS({imports:[[a.Bz.forChild(kt)],a.Bz]}),t})();var Mt=r(7054);let Yt=(()=>{class t{}return t.\u0275fac=function(e){return new(e||t)},t.\u0275mod=s.oAB({type:t}),t.\u0275inj=s.cJS({imports:[[o.ez,St,i.u5,i.UX,Mt.m]]}),t})()}}]);