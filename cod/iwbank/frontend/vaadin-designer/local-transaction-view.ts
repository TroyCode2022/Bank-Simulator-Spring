import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/number-field/src/vaadin-number-field.js';

@customElement('local-transaction-view')
export class MakeTransactionView extends LitElement {
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
<vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="width: 100%; height: 100%;">
 <h2 id="h2" style="flex-grow: 0; align-self: flex-start; padding: var(--lumo-space-xs);">Realizar un traspaso</h2>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="width: 100%;">
  <vaadin-text-field style="padding: var(--lumo-space-s);" id="vaadinTextField"></vaadin-text-field>
  <vaadin-number-field style="padding: var(--lumo-space-s);" id="vaadinNumberField"></vaadin-number-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="width: 100%;">
  <vaadin-combo-box style="padding: var(--lumo-space-s); width: 100%;" id="vaadinComboBox"></vaadin-combo-box>
  <vaadin-combo-box style="padding: var(--lumo-space-s); width: 100%;" id="vaadinComboBox1"></vaadin-combo-box>
 </vaadin-horizontal-layout>
 <span id="span">
  <vaadin-button id="vaadinButton"></vaadin-button> &nbsp; 
  <vaadin-button id="vaadinButton1"></vaadin-button></span>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
