import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/form-layout/src/vaadin-form-layout.js';
import '@vaadin/form-layout/src/vaadin-form-item.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';

@customElement('create-client-view')
export class CreateClientView extends LitElement {
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
<vaadin-vertical-layout style="margin-left:10px; margin-left: 10px;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout id="horizontal1">
  <h2 id="h2">Editar Datos Personales:</h2>
 </vaadin-horizontal-layout>
 <vaadin-form-layout id="vaadinFormLayout" style="flex-grow: 1; flex-shrink: 1; margin-left:-10px; margin-left: 10px; margin-top: -60px; width: 60%;">
  <vaadin-form-item></vaadin-form-item>
  <vaadin-form-item></vaadin-form-item>
  <vaadin-form-item></vaadin-form-item>
  <vaadin-form-item></vaadin-form-item>
  <vaadin-form-item></vaadin-form-item>
  <vaadin-form-item></vaadin-form-item>
 </vaadin-form-layout>
 <div id="div" style="align-self: flex-start; flex-grow: 1; margin-left: var(--lumo-space-s);"></div>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
