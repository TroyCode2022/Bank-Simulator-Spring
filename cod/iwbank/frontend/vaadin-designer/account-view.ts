import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/split-layout/src/vaadin-split-layout.js';
import '@vaadin/charts/src/vaadin-chart.js';

@customElement('account-view')
export class AccountView extends LitElement {
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
<vaadin-split-layout orientation="vertical" id="vaadinSplitLayout" style="width: 100%; height: 100%;">
 <div>
  <h2 id="h2" style="padding: 10px;">Cuenta</h2>
  <vaadin-chart type="column" subtitle=" " categories="" additional-options="{ &quot;tooltip&quot;: {  &quot;shared&quot;: true  }  }" id="vaadinChart"></vaadin-chart>
 </div>
 <vaadin-split-layout slot="secondary" id="vaadinSplitLayoutDown">
  <div id="divIzdo" style="align-self: flex-start; padding: var(--lumo-space-xs);">
   <b>LISTA DE INGRESOS</b>
   <vaadin-grid id="vaadinGrid" is-attached multi-sort-priority="prepend"></vaadin-grid>
  </div>
  <div slot="secondary" id="divDcho" style="padding: var(--lumo-space-xs); flex-shrink: 1; align-self: flex-start;">
   <b>LISTA DE GASTOS</b>
   <vaadin-grid id="vaadinGrid1" is-attached multi-sort-priority="prepend"></vaadin-grid>
  </div>
 </vaadin-split-layout>
</vaadin-split-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
