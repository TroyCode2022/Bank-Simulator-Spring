import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('link-account-view')
export class LinkAccountView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="width: 100%; height: 100%; align-items: flex-start; margin-left:10px;">
 <h2 id="h2">Asignar Cuenta Bancaria a Usuario</h2>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="justify-content: flex-start;">
  <div id="div">
    Elija un Usuario: 
   <br>
   <vaadin-combo-box id="vaadinComboBox"></vaadin-combo-box>
  </div>
  <div id="div1" style="align-self: flex-start;">
    Elija una Cuenta Bancaria: 
   <br>
   <vaadin-combo-box id="vaadinComboBox1"></vaadin-combo-box> &nbsp; 
   <vaadin-button id="vaadinButton2" tabindex="0"></vaadin-button>
  </div>
 </vaadin-horizontal-layout>
 <span style="padding: var(--lumo-space-s);" id="span">
  <vaadin-button id="vaadinButton" style="padding: var(--lumo-space-s);" tabindex="0"></vaadin-button> &nbsp; 
  <vaadin-button style="padding: var(--lumo-space-s);" tabindex="0" id="vaadinButton1"></vaadin-button></span>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
