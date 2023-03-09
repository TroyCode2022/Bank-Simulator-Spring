import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('unlink-account-view')
export class UnlinkAccountView extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;margin-left:10px;">
 <h2 style="flex-grow: 1;">Eliminar cliente de cuenta</h2>
 <vaadin-horizontal-layout id="vaadinHorizontalLayout" style="width: 100%; height: 100%;">
  <div>
    Seleccione Cliente: 
   <br>
   <vaadin-combo-box id="vaadinComboBox"></vaadin-combo-box>
   <vaadin-button id="vaadinButton" tabindex="0"></vaadin-button>
   <br>
   <div id="divGrid1">
     Div 
   </div>
  </div>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
